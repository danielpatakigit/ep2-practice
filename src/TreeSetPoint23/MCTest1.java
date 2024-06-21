package TreeSetPoint23;// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle TreeSetPoint23.MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "s sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
                        "Nach welchen der folgenden Aufruf-Sequenzen liefert 's.peekFirst()'\n" +
                        "die Zahl 7 als Ergebnis?",

                        new Choice(true, "s.addFirst(7); s.addFirst(0); s.addFirst(s.peekLast());                       (1A)"),
                        new Choice(false, "s.addFirst(7); s.addFirst(0); s.pollLast();                                   (1B)"),
                        new Choice(false, "s.addLast(3); s.addLast(0); s.addLast(7);                                     (1C)"),
                        new Choice(false, "s.addLast(7); s.addLast(0); s.addFirst(s.peekLast());                         (1D)"),
                        new Choice(false, "s.addFirst(7); s.addFirst(0); s.peekFirst();                                  (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf dynamisches und statisches Binden?",

                        new Choice(true, "Dynamisches Binden ist zusammen mit Untertypbeziehungen nötig.                (2A)"),
                        new Choice(true, "Private Methoden werden immer statisch gebunden.                              (2B)"),
                        new Choice(false, "Ein deklarierter Typ ist stets ein Interface, keine Klasse.                   (2C)"),
                        new Choice(true, "Objektmethoden werden im dynamischen Typ des Objekts ausgeführt.              (2D)"),
                        new Choice(true, "Klassenmethoden werden immer statisch gebunden.                               (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf die Unterscheidung zwischen\n" +
                        "Datenstrukturen und abstrakten Datentypen?",

                        new Choice(false, "Datenstrukturen lassen offen, wie Daten zusammenhängen.                       (3A)"),
                        new Choice(true, "Abstrakte Datentypen müssen keine Datenstrukturen beschreiben.                (3B)"),
                        new Choice(false, "Datenstrukturen legen die Typen ihrer Einträge fest.                          (3C)"),
                        new Choice(false, "Jede Datenstruktur hat eine festgelegte Maximalgröße.                         (3D)"),
                        new Choice(true, "Abstrakte Datentypen beschreiben vorwiegend Schnittstellen.                   (3E)")
                ),

                new Question(
                        "k sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
                        "ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
                        "    STree k = new STree(); k.add(7); k.add(3); k.add(8);\n" +
                        "Welche der folgenden Aussagen treffen auf k zu?",

                        new Choice(true, "Der Knoten mit Wert 3 ist Kind von dem mit Wert 7.                            (4A)"),
                        new Choice(false, "Der Knoten mit Wert 3 ist Elter von dem mit Wert 8.                           (4B)"),
                        new Choice(false, "Der Baum hat maximale Tiefe für einen Baum mit 3 Knoten.                      (4C)"),
                        new Choice(false, "Der Knoten mit Wert 8 ist die Wurzel.                                         (4D)"),
                        new Choice(true, "Der Knoten mit Wert 3 ist ein Blattknoten.                                    (4E)")
                ),

                new Question(
                        "M und L seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
                        "fehlerfrei compiliert: 'L p = new M();  p.n();'\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden M, L, p und n() zu?",

                        new Choice(false, "M kann Klasse oder Interface sein.                                            (5A)"),
                        new Choice(true, "Durch 'p.n()' wird die Methode in M ausgeführt.                               (5B)"),
                        new Choice(false, "L und M müssen gleich sein.                                                   (5C)"),
                        new Choice(true, "Es gilt: 'p instanceof M'.                                                    (5D)"),
                        new Choice(false, "L muss ein Interface sein (keine Klasse).                                     (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. s sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert 's.peekFirst()'\n" +
            "    die Zahl 7 als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX s.addFirst(7); s.addFirst(0); s.addFirst(s.peekLast());                       (1A)\n" +
            "    XXXXXXXXX s.addFirst(7); s.addFirst(0); s.pollLast();                                   (1B)\n" +
            "    XXXXXXXXX s.addLast(3); s.addLast(0); s.addLast(7);                                     (1C)\n" +
            "    XXXXXXXXX s.addLast(7); s.addLast(0); s.addFirst(s.peekLast());                         (1D)\n" +
            "    XXXXXXXXX s.addFirst(7); s.addFirst(0); s.peekFirst();                                  (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen stimmen in Bezug auf dynamisches und statisches Binden?\n" +
            "    \n" +
            "    XXXXXXXXX Dynamisches Binden ist zusammen mit Untertypbeziehungen nötig.                (2A)\n" +
            "    XXXXXXXXX Private Methoden werden immer statisch gebunden.                              (2B)\n" +
            "    XXXXXXXXX Ein deklarierter Typ ist stets ein Interface, keine Klasse.                   (2C)\n" +
            "    XXXXXXXXX Objektmethoden werden im dynamischen Typ des Objekts ausgeführt.              (2D)\n" +
            "    XXXXXXXXX Klassenmethoden werden immer statisch gebunden.                               (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen stimmen in Bezug auf die Unterscheidung zwischen\n" +
            "    Datenstrukturen und abstrakten Datentypen?\n" +
            "    \n" +
            "    XXXXXXXXX Datenstrukturen lassen offen, wie Daten zusammenhängen.                       (3A)\n" +
            "    XXXXXXXXX Abstrakte Datentypen müssen keine Datenstrukturen beschreiben.                (3B)\n" +
            "    XXXXXXXXX Datenstrukturen legen die Typen ihrer Einträge fest.                          (3C)\n" +
            "    XXXXXXXXX Jede Datenstruktur hat eine festgelegte Maximalgröße.                         (3D)\n" +
            "    XXXXXXXXX Abstrakte Datentypen beschreiben vorwiegend Schnittstellen.                   (3E)\n" +
            "\n" +
            " 4. k sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
            "    ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
            "        STree k = new STree(); k.add(7); k.add(3); k.add(8);\n" +
            "    Welche der folgenden Aussagen treffen auf k zu?\n" +
            "    \n" +
            "    XXXXXXXXX Der Knoten mit Wert 3 ist Kind von dem mit Wert 7.                            (4A)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 3 ist Elter von dem mit Wert 8.                           (4B)\n" +
            "    XXXXXXXXX Der Baum hat maximale Tiefe für einen Baum mit 3 Knoten.                      (4C)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 8 ist die Wurzel.                                         (4D)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 3 ist ein Blattknoten.                                    (4E)\n" +
            "\n" +
            " 5. M und L seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
            "    fehlerfrei compiliert: 'L p = new M();  p.n();'\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden M, L, p und n() zu?\n" +
            "    \n" +
            "    XXXXXXXXX M kann Klasse oder Interface sein.                                            (5A)\n" +
            "    XXXXXXXXX Durch 'p.n()' wird die Methode in M ausgeführt.                               (5B)\n" +
            "    XXXXXXXXX L und M müssen gleich sein.                                                   (5C)\n" +
            "    XXXXXXXXX Es gilt: 'p instanceof M'.                                                    (5D)\n" +
            "    XXXXXXXXX L muss ein Interface sein (keine Klasse).                                     (5E)\n" +
            "\n";

    public static final long UID = 247133588240477L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("Richtig: ", "XXXXXXXXX").replace("Falsch:  ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Statt der Zeile: " + fl + "\nsollte stehen:   " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "Das sind die erwarteten Fragen und Antwortmöglichkeiten in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("ACHTUNG: Sie haben Programmteile verändert, die nicht geändert werden sollten.\n" +
                    "Beurteilt wird so, als ob diese Programmteile unverändert geblieben wären.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("Die Multiple-Choice-Fragen wurden folgendermaßen beantwortet\n" +
                "(das sind nur Ihre Antworten, keine Aussage über Korrektheit):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "Richtig:  " : "Falsch:   ") + answer;
        }
    }
}