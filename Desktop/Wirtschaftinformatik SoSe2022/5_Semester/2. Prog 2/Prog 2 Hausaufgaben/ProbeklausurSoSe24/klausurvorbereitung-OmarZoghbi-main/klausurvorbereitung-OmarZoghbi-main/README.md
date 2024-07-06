[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/hLRdbQnS)
# Übungs-Klausur Angewandte Programmierung

Die Klausur besteht aus zwei Teilen: einem praktischen und einem theoretischen Teil. Für 100% (also Note 1,0) müssen Sie 120 Punkte erreichen.
Sie haben insgesamt 90 Minuten Zeit für die Bearbeitung, massgeblich ist der Zeitstempel des entsprechenden Commits.
Sie müssen Ihre Abgabe auf mindestens vier Commits aufteilen (z.B. 1x für Antworten zum Code, 1x für Test-Code, 1x für allgemeine Antworten, 1x für Implementierungs-Code), ansonsten gibt es Punktabzug von bis zu 20 Punkten.
Es handelt sich um eine Open-Book-Klausur, Sie müssen jedoch nicht offensichtliche Quellen ausreichend kennzeichnen und dürfen keine fremde Leistung als Ihre eigene darstellen.
Füllen Sie daher bitte zuerst die Datei [ERKLAERUNG.md](ERKLAERUNG.md) aus, bevor Sie mit der Bearbeitung der Klausur beginnen.
Bei der Verwendung von ChatGPT o.Ä. müssen die gesamte Konversation dokumentieren, am besten in einer separaten Datei.

## Theoretischer Teil (60 Punkte)

Beantworten Sie die Fragen, die Sie in der Datei [QUESTIONS.md](QUESTIONS.md) finden.
Die Fragen beziehen sich teilweise auf den Code in diesem Repository.
Schreiben Sie Ihre Antworten direkt in diese Datei unter die jeweilige Frage.
Wenn sinnvoll, schreiben Sie Freitext, jedoch höchstens drei Sätze pro Frage (in der Regel weniger). Bei zu umfangreichen Antworten gibt es Punktabzug.
Bei manchen Fragen ist eine Beantwortung als Auflistung sinnvoller, aber achten Sie hier darauf, dass es unmissverständlich ist, was Sie auflisten.
Reichen Sie das Ergebnis per Git Commit & Push ein. 
Sie können die Beantwortung über mehrere Commits verteilen und Ihre Antworten bis zum Ende der Bearbeitungszeit korrigieren.


## Praktischer Teil (60 Punkte)

Betrachten Sie die Klasse `Accounting` im Package `/service/accounting`, sowie das Interface `ReadOnlyInvoice`.
Implementieren Sie die zwei Methoden `createInvoice` und `calculateRevenue` so wie durch das entsprechende JavaDoc spezifiziert und erstellen Sie dafür eine Klasse `Invoice`, welche `ReadOnlyInvoice` implementiert (30 Punkte).
Erstellen Sie ausserdem für beide Methoden jeweils mindestens zwei automatische Testfälle, welche unterschiedliches Verhalten testen, also insgesamt mindestens vier (30 Punkte).
Achtung: in der echten Klausur könnte es sein, dass Sie die Methoden-Spezifikation separat erhalten, d.h. verlassen Sie sich nicht darauf, dass Ihnen bspw. GitHub Co-Pilot hier Lösungen vorschlägt.