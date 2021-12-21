/**
 * @author serguun42
 * @description Compile all source code into single Markdown file
 */

const { join } = require("path");
const { readdir, readFile, stat, writeFile } = require("fs");
const { promisify } = require("util");
const fsReadDir = promisify(readdir);
const fsReadFile = promisify(readFile);
const fsWriteFile = promisify(writeFile);
const fsStats = promisify(stat);

const JAVA_LABS_BASE_DIR = join("src", "ru", "serguun42", "java");
const PACKAGE_PREFIX = "ru.serguun42.java";
const OUT_FILE = "CombinedJava.md";

/** @type {{ filename: string, package: string, data: string }[]} */
const FILES = [];

/**
 * @param {string} folder
 * @returns {Promise}
 */
function ReadFolder(folder) {
	return fsReadDir(folder)
	.then((files) => Promise.all(
		files.map((file) => {
			const completeFilename = join(folder, file);
			
			return fsStats(completeFilename)
			.then((stats) => {
				if (stats.isDirectory())
					return ReadFolder(completeFilename);

				return fsReadFile(completeFilename)
				.then((fileContent) => {
					const fineFilename = completeFilename
											.replace(JAVA_LABS_BASE_DIR, "")
											.replace(/\\/g, "/");

					if (fineFilename.match(/\.(jpg|png)$/))
						return Promise.resolve(true);

					FILES.push({
						filename: fineFilename.match(/^(.*)\/([^\.]+\.\w+)$/)?.[2],
						package: fineFilename.match(/^(.*)\/([^\.]+\.\w+)$/)?.[1]?.replace(/\//g, "."),
						data: fileContent.toString()
					});

					return Promise.resolve(true);
				});
			});
		})
	))
	.catch(console.warn);
}

ReadFolder(JAVA_LABS_BASE_DIR)
.then(() => {
	/** @type {{ [package: string]: { filename: string, data: string }[] }} */
	const BY_PACKAGE = {};

	FILES.forEach((file) => {
		if (!BY_PACKAGE[file.package])
			BY_PACKAGE[file.package] = [];

		BY_PACKAGE[file.package].push({
			filename: file.filename,
			data: file.data
		});
	});

	const SORTED_PACKAGES = Object.keys(BY_PACKAGE).sort((prev, next) => {
		const prevPrefix = prev.match(/^([a-z]+)/i)?.[1];
		const nextPrefix = next.match(/^([a-z]+)/i)?.[1];
		const prevNumber = parseInt(prev.match(/^([a-z]+)(\d+)/i)?.[2]) || prev.match(/^([a-z]+)(\d+)/i)?.[2] || Infinity;
		const nextNumber = parseInt(next.match(/^([a-z]+)(\d+)/i)?.[2]) || next.match(/^([a-z]+)(\d+)/i)?.[2] || Infinity;

		if (prevPrefix === nextPrefix)
			return prevNumber - nextNumber;

		return prevPrefix - nextPrefix;
	});

	
	const OUT_DATA = SORTED_PACKAGES.map((packageName) => `## Package: ${PACKAGE_PREFIX}${packageName}\n\n${
		BY_PACKAGE[packageName].map((file) => `### Файл ${file.filename}:\n\`\`\`java\n${file.data}\`\`\``).join("\n\n")
	}`);

	return fsWriteFile(OUT_FILE, OUT_DATA.join("\n\n\n\n"));
})
.then(() => console.log(`Created out file – ${OUT_FILE}`))
.catch(console.warn);
