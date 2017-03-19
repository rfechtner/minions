# minions
Home of the GoBi project block phase

Zunächst wollen wir uns mit MinION Daten auseinandersetzen und deren Charakteristika kennenlernen. 
Dazu nutzen wir unsere fertigen Programme aus den Übungsaufgaben und wenden die Pipeline auf einen 
MinION- und Illumina-Datensatz aus dem selben Paper an, um schließlich die Daten von beiden 
Sequencern zu vergleichen.

Task 1.1 (Pipeline anpassen) (1 U):

Die für unser Projekt-Blockteil relevante Aufgaben beschränken sich auf:

 - Exercise 1: Task 1
 - Exercise 2: Task 1 – 4 
 - Exercise 3: Task 1 – 6

Diese zunächst separate Aufgabenteile fügen wir zu einer zusammenhängenden automatisierten Pipeline
zusammen. Außerdem erzeugen wir eine Version der Pipeline, die das Streaming-Interface von Unix 
nutzt, um eine direkt für MinION-online-Mapping nutzbare Pipeline zu erhalten.

Output: Vollständige, automatisierte Pipeline


Task 1.2 (Pipeline anwenden) (2 U):

Wir nutzen die Datensätze aus “Benchmarking of the Oxford Nanopore MinION sequencing for 
quantitative and qualitative assessment of cDNA populations” [S. Oikonomopoulos et.al., 2016]
(http://www.nature.com/articles/srep31602) um die einzelnen Ergebnisse dieses Papers zu 
reproduzieren und validieren.

Dazu finden wir im ENA (Accession Number: PRJEB 11818) (http://www.ebi.ac.uk/ena/data/view/PRJEB11818) 
das Sequencing-Projekt mit den zugehörigen Reads für MinION und Illumina MiSeq. Weiter benötigen wir 
das GTF- und Fasta-File des menschlichen Genoms, welches wir bereits im Übungsteil verwendet haben: 
/home/proj/biosoft/praktikum/genprakt/assignment/a1/data/Homo_sapiens.GRCh37.75.gtf und 
/home/proj/biosoft/praktikum/genprakt/genome/Homo_sapiens.GRCh37.75.dna.toplevel.fa

Output: Annotierte / Alignierte Reads (MinION und Illumina)

Für den Vergleich von:
 - MinION mit verschiedenen Mappern gegen Illumina
 - HighQuality und LowQuality Reads von MinION

erstellen wir folgende Plots:
 - Density Plot: Reads zu Region (Vergleich zwischen Methoden und Mappern)
 - Kumulative Verteilung Reads pro Transkript 
 - Kumulative Verteilung der Read Längen
 - Laufzeit und Speicherbedarf der MinION Mapper


Task 2.1 & 2.2 (Simulator anpassen & anwenden) (1+1 U):

Wir modifizieren den Simulator aus der Pipeline um transkriptomische MinION Reads zu generieren 
um den Mapper testen zu können. Dieser Simulator soll die MinION typischen Fehler-Profile möglichst 
realitätsnah nachbilden, aber auch variabel genug sein um niedrigere Fehlerraten (z.B. für zukünftige 
MinION Versionen) zu ermöglichen.

Weiter führen wir für verschiedene Parameter des Simulators die unter 1.2 erwähnte Pipeline aus. 
Dabei entstehen die selben Plots, die wir anschließend mit den Plots der echten Daten vergleichen.

Output: 
 - Simulator
 - Parameter für den Simulator, die MinION Reads der aktuellen Version am besten simulieren

Plots: 
 - Plots aus 1.2 für verschiedene Parameter


Task 3.1 (Vorhandene Mapper evaluieren) (3 U):

Um einen auf MinION Read optimieren Mapper zu entwerfen evaluieren wir das Aufbauschema und die 
Funktionsweise etablierter Mapper für lange Reads aus gängigen NGS Sequencern. Dazu gehen wir besonders 
auf die neueste Version von GraphMap (Open-Source zu finden auf GitHub) (https://github.com/isovic/graphmap) 
ein.

Output: 
 - Präsentation zu der Funktionsweise und Spezifika verschiedener Mapper (LAST, BWA-MEM, GraphMap)
 - Skizze für neuen, optimierten Mapper und die Unterteilung der Funktionsblöcke


Task 3.2 (Mapper kontruieren) (6 U):

Basierend auf den Ergebnissen aus Task 3.1 und Task 2.2 wollen wir einen auf die langen und fehlerbehafteten 
transkriptomischen MinION Reads optimierten Mapper konstruieren.

Genauer zu untersuchende Aspekte stellen:
 - Finden von Seeds (Länge, Spacing, erlaubte Fehler, Bewertung)
 - Filtern von Seeds (Entfernung, Linearität)
 - Verlängern von Seeds (Laufzeit durch Einschränkung der Möglichkeiten, Speicherbedarf)
 - Stitching der verlängerten Seeds

Output: [NAME: CLASSIFIED, Codename: Gru] – Mapper 


Task 3.3.1 & 3.3.2 (Mapper anwenden & analysieren) (1+1 U):

Um die Qualität des von uns entworfenen Mappers zu überprüfen, wenden wir ihn in der Pipeline aus 
Task 1.1 mit simulierten Daten aus Task 2.1 und echten Daten aus dem unter Task 1.1 erwähnten Paper an. 
Basierend auf den Ergebnissen werden wir den Mapper weiter verbessern. Die daraus resultierenden Plots 
präsentieren wir mit vollem Stolz bei der glorreichen Abschlusspräsentation. 

Output: 
 - Plots aus Task 1.2 für denen Optimierungsdurchlauf


Task 4 (Gesamtergebnis) (1+1+1 U)

Für die Endpräsentation erstellen Übersicht über allgemeine Funktionsweise und Charakteristika der Reads. 
Wir führen die Plots der verschiedenen Tasks zusammen und vergleichen diese für die Ergebnisse des Papers, 
des Simulators und des von uns konstruierten Mappers. Weiter stellen wir das generelle Schema und die 
Besonderheiten unseres [NAME: CLASSIFIED, Codename: Gru]-Mappers vor. 

Output: 
 - Präsentation für die Abschlusspräsentation
 - Plakat
 - Abschlussbericht 
