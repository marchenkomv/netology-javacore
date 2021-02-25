В данной задаче вам необходимо реализовать класс Worker, который будет выполнять некоторые задачи и возвращать результат в родительский класс Main.
Для того, чтобы класс Worker мог вернуть резлультат своей работы, реализуйте собственный функциональный интерфейс OnTaskDoneListener. В нем определите только один метод onDone() без реализации и пометьте интерфейс аннотацией @FunctionalInterface.
Добавьте в класс Worker переменную callback типа OnTaskDoneListener, передайте в класс Worker ее значение через конструктор.
Смоделируйте выполнение классом Worker какой либо работы.
---------------------------------------------------------
Может случиться так, что выполнение одной из задач может закончиться неуспешно. Смоделируйте ситуацию, в которой 33 задача закончится неуспешно, и выведите информацию об этом в класс Main. Для этого создайте новый функциональный интерфейс OnTaskErrorListener, определите там метод onError(). Добавьте в класс Worker переменную errorCallback типа OnTaskErrorListener. Значение переменной передавайте так же через конструктор. Таким образом, в консоле после выполнения вашего кода все задачи, кроме 33, должны закончиться успешно, а 33 - оповестит об ошибке.