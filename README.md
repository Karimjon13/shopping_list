# 🛒 ShoppingList

Android-приложение для списка покупок, написанное на Kotlin.

## Возможности
- Добавление покупки с названием и количеством
- Редактирование по нажатию на элемент
- Удаление свайпом влево или вправо
- Отметка «куплено» долгим нажатием (элемент меняет цвет)
- Проверка ввода с подсказками об ошибках
- Двухпанельный режим в горизонтальной ориентации: список и форма рядом
- Сохранение списка между запусками

## Технологии
- Kotlin
- Архитектура MVVM + Clean Architecture (слои data / domain / presentation)
- ViewModel, LiveData
- RecyclerView + ListAdapter с несколькими типами элементов
- Fragments, Activity
- ItemTouchHelper
- SharedPreferences (JSON)

## Скриншоты
<img width="1080" height="2400" alt="Screenshot_20261126_212506" src="https://github.com/user-attachments/assets/91829d6b-4a0c-4daa-8fde-ecd1625d2563" />
<img width="1080" height="2400" alt="Screenshot_20261126_212543" src="https://github.com/user-attachments/assets/263f830a-1d26-4a0c-9224-cf9cf21b0c87" />
<img width="2400" height="1080" alt="Screenshot_20261126_212758" src="https://github.com/user-attachments/assets/24a147b3-11bd-486d-95c7-05336e8985de" />
<img width="2400" height="1080" alt="Screenshot_20261126_212644" src="https://github.com/user-attachments/assets/5f012d45-3f1f-4ea0-899b-f8caf6559172" />


## Установка
Скачайте `app-release.apk` из раздела [Releases](../../releases) и установите на устройство с Android 10 или новее.
