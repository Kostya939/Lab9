# Excel Product Exporter
Цей проект є утилітою для автоматизованого експорту інформації про продукти з онлайн API до файлу Excel. Він дозволяє збирати дані про продукти з веб-сервісу та зберігати їх у структурованому форматі Excel для подальшого аналізу або використання.

## Структура проекту
Проект складається з наступних компонентів:

- **Product**: Клас, що представляє інформацію про продукт, включаючи ID, назву, ціну та опис.
- **ProductFetcher**: Клас, який використовує HTTP запити для отримання інформації про продукти з веб-API.
- **ProductExcelExporter**: Клас, що відповідає за експорт зібраних даних про продукти у файл Excel.
- **ProductTests**: Клас з тестами JUnit для перевірки функціональності класів `Product` та `ProductExcelExporter`.

## Використання
Для запуску проекту виконайте головний клас, який ініціює процес збору даних та експорту в Excel. Зібрані дані про продукти будуть збережені у вказаному файлі Excel.

## Тестування
Для перевірки коректності роботи класів використовуються JUnit тести, розташовані у класі `ProductTests`. Вони включають базові тести для створення об'єктів `Product` та експорту даних у файл Excel.

## Вимоги до середовища
Для роботи з цим проектом вам потрібно мати наступне:

- Java Development Kit (JDK)
- Система управління залежностями, така як Maven або Gradle (для управління бібліотеками, такими як Apache POI та Jackson)
- Бібліотека Apache POI (для роботи з файлами Excel)
- Бібліотека Jackson (для роботи з JSON та HTTP запитами)

## Автор
Автор: [Козачок Костянтин]
