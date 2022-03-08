# Dualis-Bot

![Dualis-Bot Logo](img/dualis-bot.png?raw=true "Dualis-Bot Logo")

## Übersicht über die Applikation

Die Duale Hochschule Baden-Württemberg nutzt das Tool Moodle als Studierendenverwaltungssystem. Das Portal Dualis ist ein Teil des Moodle-Softwarepakets. Mit Hilfe des Dualis Web-Client können Studierende Noten und weitere Informationen zum Studium abrufen.
Die Anmeldung im Portal erfolgt mithilfe eines berechtigten Benutzerkontos mit Benutzername und Passwort.

Studierende möchten möglichst schnell wissen, wenn eine Note von der zugehörigen Sekretariatsstelle auf Dualis eingetragen wurde.
Dualis bietet von Haus aus keine Möglichkeit der Benachrichtigung. Da man nicht genau weiß, wie schnell ein Dozent eine Klausur korrigiert hat, kann man auch nicht genau abschätzen, wann die Note erscheint. Dies sorgt für ein lästiges, ständiges Anmelden im Portal und der Suche nach dem Modul.

Die Idee ist es, ein Programm zu entwickeln, das sich automatisiert und regelmäßig im Portal anmeldet und sich die Daten von Dualis holt. Anschließend wird geprüft, ob eine neue Klausur eingetragen wurde. Ist dies der Fall, soll der gesamte Kurs benachrichtigt werden, aber auch die angemeldete Person selbst. Dabei enthält die Nachricht an die angemeldete Person zusätzlich die Note der Klausur, sodass ein Blick in das Portal nicht nötig ist.

Dualis bietet keine Schnittstelle an, über die die erforderlichen Daten erfasst werden können. Stattdessen gibt es das selbstentwickelte Plugin Dualis-Webscraper, das den Login ins Portal und das Auslesen der HTML-Elemente und damit der benötigten Daten ermöglicht. Es speichert die rohen gelesenen Informationen als \ac{CSV}. Erstellt werden dabei Listen mit Semestern, Modulen, Versuchen und Klausuren.

Der Dualis-Bot ruft dieses Plugin auf, erfasst auf Basis dieser Datengrundlage die neu eingetragenen Klausuren und sendet gegebenenfalls Nachrichten an Chats in Telegram über die Telegram API. 

## Wie startet man die Applikation?

Voraussetzungen:
- Das Dualis-Webscraping Plugin (dualis-webscraper.jar) liegt im Wurzel-Verzeichnis des Dualis-Bot (Entwicklung) oder im selben Verzeichnis der Dualis-Bot JAR.
- Das Wurzel-Verzeichnis, in der die Anwendung liegt, enthält die Verzeichnisse `old-results` und `new-results`. Darin werden die Ergebnisse des Webscrapers gespeichert.
- Optional: Maven ist installiert
- Optional: IDE (IntelliJ) ist installiert

Wie wird die Applikation gestartet:
- Über die IDE (IntelliJ):
  1. Öffne das Modul 1-adapters.
  2. Lokalisiere die Klasse com.schewe.dualisbot.entrypoint.Main.
  3. Starte die main-Methode.
- Über die Kommandozeile (JAR):
  1. Öffne die Kommandozeile im Wurzelverzeichnis des Projekt.
  2. Führe `java -jar dualis-bot.jar` aus.
- Über die Kommandozeile (Maven):
  1. Öffne die Kommandozeile im Wurzelverzeichnis des Projekt.
  2. Führe `mvn exec:java` aus.

## Wie testet man die Applikation?

Voraussetzungen:
- Maven ist installiert
- Optional: IDE (IntelliJ) ist installiert

Wie wird die Applikation getestet:
- Über die IDE (IntelliJ): Die Tests sind im Test-Verzeichnis der Module 2-application zu finden. Hier werden alle Test-Klassen gefunden und können einzeln ausgeführt werden.
- Über die Kommandozeile (Maven):
  1. Öffne die Kommandozeile im Wurzelverzeichnis des Projekt.
  2. Führe `mvn test` aus.
