# Searcher_films_desktop_app

Поисковик фильмов, сериалов. Базируется на https запросах на API сервис-сайт Omdbapi, который в ответ отправляет JSON 
страницу c указанным ответом на запрос. Лимит 1000 запросов в день. Интерфейс простенький, в поле над кнопкой "Ваш запрос"
вводим фильм или сериал на английском языке (оригинальное название) и жмем на кнопку "Ваш запрос".

![Image alt](https://github.com/pkhramov11/Searcher_films_desktop_app/raw/master/pic1.JPG)

Далее, если хотим посмотреть подробную информацию, копируем ID фильма через Ctrl-C и вставляем в поле над "Поиск по ID"
через команду Ctrl-V и жмем кнопку "Поиск по ID".

![Image alt](https://github.com/pkhramov11/Searcher_films_desktop_app/raw/master/pic2.JPG)

Если нужно перейти на следующую страницу в поиске, указываем номер страницы в поле над кнопкой "Номер страницы" и жмем на
кнопку "Номер страницы".


![Image alt](https://github.com/pkhramov11/Searcher_films_desktop_app/raw/master/pic3.JPG)

При закрытии приложение автоматически удалит созданные json файлы и картинки-постеры, которые сохранились в папке с приложением.

Целью данного проекта была тренировка с библиотекой Jackson-databind, и практика с https запросами.
Запустить проект можно через файл "Searcher_film.jar", который находится в корне проекта.
