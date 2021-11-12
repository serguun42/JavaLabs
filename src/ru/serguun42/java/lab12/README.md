# Lab 12

1. В файле [date-validation-regexp-human-readable.txt](./date-validation-regexp-human-readable.txt) содержится регулярное выражение (PRCE2) для валидации даты в заданном формате (по заданию в PDF: dd/mm/yyyy 1900-9999 года) с комментариями
2. В файле [Lab12TestRegexp.java](./Lab12TestRegexp.java) в функции `main()` переключение вызова подзаданий надо делать кодом. Выполненные подзадания:
   1. Написать регулярное выражение, определяющее является ли данная строчка датой в формате `dd/mm/yyyy`. Начиная с 1900 года до 9999 года
   2. Дан текст со списками цен. Извлечь из него цены в USD, RUВ, EUR.
   3. Написать регулярное выражение, определяющее является ли данная строка строкой `abcdefghijklmnopqrstuv18340` или нет.
   4. Необходимо реализовать консольное приложение, позволяющее манипулировать строкой, разбив ее на элементы путем использования регулярных выражений.