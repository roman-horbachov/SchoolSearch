
# Практична робота №1: Розробка програми для обробки великого обсягу даних

## Опис
Ця програма розроблена для обробки даних про студентів з файлу `students.txt`. Вона дозволяє виконувати пошук студентів за різними критеріями, такими як:
- Прізвище студента
- Номер класу
- Номер автобуса
- Прізвище викладача

Програма працює в командному рядку і забезпечує зручний інтерфейс для пошуку та виведення результатів.

## Мета роботи
Метою даної роботи було розробити програму, яка може обробляти великий обсяг даних, зокрема пошук студентів за різними критеріями, використовуючи інформацію з текстового файлу.

## Постановка задачі
Програма повинна:
- Читати файл `students.txt` з даними про студентів.
- Виконувати пошук студентів за прізвищем, прізвищем викладача, номером класу та автобусного маршруту.
- Підтримувати опцію виведення тільки номера автобуса для студента.

## Технології
- Мова програмування: Java
- Використовується стандартний ввід/вивід в командному рядку для введення команд пошуку та відображення результатів.

## Використання
Після запуску програми в командному рядку ви можете вводити такі команди:

- Пошук студента за прізвищем:
  ```
  S:<lastname>
  ```
  Наприклад:
  ```
  S:COOKUS
  ```

- Пошук студента за прізвищем і автобусом:
  ```
  S:<lastname> B
  ```
  Наприклад:
  ```
  S:COOKUS B
  ```

- Пошук за прізвищем викладача:
  ```
  T:<lastname>
  ```

- Пошук за номером класу:
  ```
  C:<classroom>
  ```

- Пошук за номером автобусного маршруту:
  ```
  B:<busnumber>
  ```

- Завершення роботи:
  ```
  Q
  ```

## Результати роботи
Програма коректно реалізує пошук за зазначеними критеріями та виводить відповідні результати. Нижче наведено приклади роботи програми:

- Пошук студента за прізвищем: `S:<lastname>`
- Пошук студента за прізвищем і автобусом: `S:<lastname> B`
- Пошук за прізвищем викладача: `T:<lastname>`
- Пошук за номером класу: `C:<classroom>`
- Пошук за номером автобусного маршруту: `B:<busnumber>`

## Висновки
Програма була успішно розроблена та протестована. Вона підтримує всі необхідні функції пошуку, що відповідають завданню. Програма була написана на мові Java і може бути використана в командному рядку для пошуку студентів за різними критеріями.

## Посилання
Посилання на GitHub-репозиторій: [GitHub](https://github.com/roman-horbachov/SchoolSearch)
