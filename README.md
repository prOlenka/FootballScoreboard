# Football World Cup Scoreboard

## 📋 Описание
Простая Java-библиотека для отслеживания матчей и счётов в реальном времени.

## 📦 Поддерживаемые функции

- Старт матча (`startGame`)
- Завершение матча (`finishGame`)
- Обновление счёта (`updateScore`)
- Получение итогов матчей (`getSummary`)

## ✅ Пример использования

```java
Scoreboard board = Scoreboard.getInstance();
board.startGame("Argentina", "Australia");
board.updateScore("Argentina", "Australia", 3, 1);
List<Match> summary = board.getSummary();
summary.forEach(System.out::println);
