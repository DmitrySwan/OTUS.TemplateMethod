# OTUS.TemplateMethod
Проект в рамках обучения на платформе OTUS.

## Курс: Архитектура и шаблоны проектирования.

### Занятия: Шаблонный метод.

Задание: Реализация выбора подходящего метода матричных операций с применением шаблонного метода и описание применения шаблона в проекте
         Цель: Получите навыки в программировании алгоритмов матричных операций, применении шаблонного метода.
         Есть несколько операций над матрицами:
         1. транспонирование матрицы
         2. сложение матриц
         3. найти определитель матрицы
         
         Написать программу, которая выполняет следующее:
         0 на входе получает название входного файла, выходного файла и вид операции
         1. Получает данные из файла
         2. Выполняет указанную операцию над данными
         3. Формирует данные для вывода в необходимом формате
         4. Записывает данные в выходной файл
         5. Если потребуется использовать Шаблонный метод в проектной работе, предоставить описание в текстовом файле в GitHub репозитории где конкретно и в какой роли используется этот шаблон.
         6. нарисовать диаграмму классов.
         
## Запуск:
1. mvn clean test -DsuiteXmlFile=testng.xml 
    или
2. mvn clean test
3. mvn clean install (если необходимо собрать исполняемый jar файл AbstractFactory-1.0-jar-with-dependencies.jar, после сборки лежит в target)

### Описание тестирования:
###### 1 Способ. Уже собранный jar-файл (TemplateMethod-1.0-jar-with-dependencies.jar) расположен в корне проекта.
Пример запуска через cmd:  java -jar TemplateMethod-1.0-jar-with-dependencies.jar -i inputFile.txt -o outputFile.txt -op determinant
типы операций: addition, determinant, transposition
Пример формата заполнения файла input можно посмотреть в src/test/resources

###### 2 Способ.Тест расположен в директории src/test/java.
input и expected output файлы лежат в src/test/resources.
В процессе запуска тестирования они программно копируются в папку target/test-classes/,
где в результате тестов(по одному тесту на каждый тип операции) генерится свой файл output, который сравнивается с expected output

### Логирование: 
Файл report.log созданиется в директории проекта/jar файла.
Содержит информацию о входных данных, способе сортировке и результате.

##### Диаграмма классов:
Файл diagram.png находится в корне проекта (сгенерирован ресурсами Intelij IDEA)

#### Версии с которыми разрабатывалось приложение:

java version "11.0.8" 2020-07-14 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.8+10-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.8+10-LTS, mixed mode)
Apache Maven 3.3.9

##### Библиотеки:

log4j:https://mvnrepository.com/artifact/log4j/log4j/1.2.17

testng:https://mvnrepository.com/artifact/org.testng/testng/7.3.0

commons-cli:https://mvnrepository.com/artifact/commons-cli/commons-cli/1.3.1

commons-io:https://mvnrepository.com/artifact/commons-io/commons-io/2.8.0
