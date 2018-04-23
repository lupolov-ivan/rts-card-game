# rts-card-game

#Технологии:
=====================
#BE
---------------------
- Maven
- JUnit+Hamcrest
- MySql
- JDBC
- SQL
- REST
- Jetty + Jersey

#FE
---------------------
- JavaScript
- Ajax
- Json
- HTML
- CSS

Ссылка на Схему базы данных:
http://dbdesigner.net/designer/schema/163015

#Краткое описание проекта:
=====================
Упрощенная RTS игра в которую можно играть вдвоем по сети.
Остовные правила:
- Используя карты нужно достичь максимального показателя определенного(будет решено какого) ресурса или добиться нулевого показателя этого ресурса у противника. 
- Карты являются единственной возможностью управлять процесом игры и они могут влиять на ресурсы здания и апгрейды собственные и противника.
- Чтобы сделать любой экшен в игре наприме: купить здание, проапгрейдить здание, пополнить ресурс, нанести удар по зданиям апгрейдам или ресурсам противника, обменять один ресурс на другой и т.д. - эти или какие либо иные придуманые экшены будут реализовываться по средствам описания действия той или иной карты. Применяя карту мы чтото тратим и чтото приобретаем у себя и у противника.
- В списке карт каждая карта может появиться тогда когда для нее есть все ее требуемые ресурсы здания и апгрейды.
- После использования карты мы создаем запрос в REST API нашего серверсайда и вычитаем все расходники из таблиц:
- `Acc_Building`  `Acc_Upgrades` `Acc_Upgrades`,
для себя и для противника.

#Описание игры:
=====================
Игра состоит из 4-х html страниц(с которых будут делаться все наши запросы в наш REST сервис с использованием JavaScript+Ajax+Json): 
1) Станица Login-а или  Create new User.
2) Страница списка всех доступных игровых комнат (Room-ов) в которых можно играть, каждый элемент списка состоит из "номер комнаты", "названия комнаты", "количесво игроков в комнате". 
Внизу таблицы 2 большие кнопки:
 * "Start in Random Room" - начать игру выбрав случайным образом комнату где уже сидит один игрок.
 * "Start in Selected Room" - если в выбраной комнате есть один игрок то сразу начать игру, если вы в комнате один то занять место в ожидании когда прийдет другой игрок и стартанет игру.
3) Страница где и происходит сам бой между игроками куда мы попадаем после старта игры. Состоит из следующих компонентов:
 * "Список Построеных Зданий" (table `Building` and `Acc_Building`)
 * "Список Полученых Ресурсов" (table `Resource` and `Acc_Resource`)
 * "Список Полученых Апгрейдов" (table `Upgrade` and `Acc_Upgrade`)
 * "Список Построеных Зданий Противника" (table `Building` and `Acc_Buildin`)
 * "Список Полученых Ресурсов Противника" (table `Resource` and `Acc_Resource`)
 * "Список полученых Апгрейдов Противника" (table `Upgrade` and `Acc_Upgrade`)
 * "Список Карт текущего игрока(список карт противника не показываем)" (tables `Сard` and  `Card_Action` возможно еще что-то)
4) Страница достижений. Таблица в которой отображаются все Ачивки набраные в играх всех игроков упорядоченая по убыванию достижений.




Для общего понимания предлагается для примера следующий набор придуманых элементов игры:
=====================
#Ресурсы
- Золото
- Мана
- Вера (параметр котрый надо вырастить до 1000)
- Камень
- Дерево
- Железо
- Еда
- Рабочие
- Волшебники                                  
- Воины
- Опыт
                                        
#Постройки
- Казармы:
---
    производит(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:10, Вера:1)
- Каменоломня:
---
    производит(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
- Прииски:
---
    производит(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
- Шахта:
---
    производит(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
- Лесопилка:
---
    производит(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
- Ферма:
---
    производит(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
- Изба:
---
    производит(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
- Алтарь:
---
    производит(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
- Обелиск:
---
    производит(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
- Храм:
---
    производит(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)


#Апгрейды
- Улучшение Казармы:
---
    производит(Золото:0%, Мана:0%, Камень:0%, Дерево:0%, Железо:0%, Еда:0%, Рабочие:0%, Волшебники:0%, Воины:0%, Вера:0)
- Улучшение Каменоломня:
---
    производит(Золото:0%, Мана:0%, Камень:0%, Дерево:0%, Железо:0%, Еда:0%, Рабочие:0%, Волшебники:0%, Воины:0%, Вера:0)
- Улучшение Прииски:
---
    производит(Золото:0%, Мана:0%, Камень:0%, Дерево:0%, Железо:0%, Еда:0%, Рабочие:0%, Волшебники:0%, Воины:0%, Вера:0)
- Улучшение Шахта:
---
    производит(Золото:0%, Мана:0%, Камень:0%, Дерево:0%, Железо:0%, Еда:0%, Рабочие:0%, Волшебники:0%, Воины:0%, Вера:0)
- Улучшение Ферма:
---
    производит(Золото:0%, Мана:0%, Камень:0%, Дерево:0%, Железо:0%, Еда:0%, Рабочие:0%, Волшебники:0%, Воины:0%, Вера:0)
- Улучшение Изба:
---
    производит(Золото:0%, Мана:0%, Камень:0%, Дерево:0%, Железо:0%, Еда:0%, Рабочие:0%, Волшебники:0%, Воины:0%, Вера:0)
- Улучшение Алтарь:
---
    производит(Золото:0%, Мана:0%, Камень:0%, Дерево:0%, Железо:0%, Еда:0%, Рабочие:0%, Волшебники:0%, Воины:0%, Вера:0)
- Улучшение Обелиск:
---
    производит(Золото:0%, Мана:0%, Камень:0%, Дерево:0%, Железо:0%, Еда:0%, Рабочие:0%, Волшебники:0%, Воины:0%, Вера:0)
- Улучшение Храм:
---
    производит(Золото:0%, Мана:0%, Камень:0%, Дерево:0%, Железо:0%, Еда:0%, Рабочие:0%, Волшебники:0%, Воины:0%, Вера:0)

#Карты
- Построить Казармы:
---
    требует постройку(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    требует апгрейд(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые постройки(Казармы:1, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на вражеские постройки(Казармы:0, Каменоломня:3, Прииски:3, Шахта:3, Ферма:3, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:1, Рабочие:10, Волшебники:-100, Воины:0, Вера:2)
    (+/-)влияет на вражеские ресурсы(Золото:-100, Мана:-200, Камень:0, Дерево:0, Железо:-300, Еда:-400, Рабочие:-30, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на собственый апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)    
- Построить Каменоломня:
---
    требует постройку(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    требует апгрейд(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на вражеские постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на собственый апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)   
- Построить Прииски:
---
    требует постройку(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    требует апгрейд(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на вражеские постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на собственый апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)   
- Построить Шахта:
---
    требует постройку(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    требует апгрейд(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на вражеские постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на собственый апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)   
- Построить Лесопилка:
---
    требует постройку(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    требует апгрейд(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на вражеские постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на собственый апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)   
- Построить Ферма:
---
    требует постройку(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    требует апгрейд(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на вражеские постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на собственый апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)   
- Построить Изба:
---
    требует постройку(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    требует апгрейд(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на вражеские постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на собственый апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)   
- Построить Алтарь:
---
    требует постройку(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    требует апгрейд(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на вражеские постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на собственый апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)   
- Построить Обелиск:
---
    требует постройку(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    требует апгрейд(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на вражеские постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на собственый апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)   
- Построить Храм:
---
    требует постройку(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    требует апгрейд(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на вражеские постройки(Казармы:0, Каменоломня:0, Прииски:0, Шахта:0, Ферма:0, Изба:0, Алтарь:0, Обелиск:0, Храм:0)
    (+/-)влияет на собственые ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские ресурсы(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на собственый апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)
    (+/-)влияет на вражеские апгрейд(Золото:0, Мана:0, Камень:0, Дерево:0, Железо:0, Еда:0, Рабочие:0, Волшебники:0, Воины:0, Вера:0)   




