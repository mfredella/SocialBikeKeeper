**Social Bike Keeper**

Ingegneria del Software

**Caruso Sara 399000113**

**Fredella Michele 399000104**

**Fucci Marianna 399000112\
**

**\
**

**Analisi e specifica dei requisiti software**

1 Introduzione {#introduzione .Marianna1}
==============

1.1 Obiettivo {#obiettivo .Marianna2}
-------------

L'obiettivo di tale documento è illustrare i requisiti di
un'applicazione che dia supporto agli sportivi, in particolar modo ai
ciclisti amatoriali. Tale supporto verrà fornito attraverso
un'applicazione mobile per il sistema operativo Android.

Gli utenti dell'applicazione sono:

-   *Ciclisti amatoriali*: coloro che interagiscono con l'applicazione
    per:

    -   Visualizzare la propria posizione su una mappa

    -   Iniziare una sessione di allenamento

    -   Fare analisi post-allenamento

    -   Visualizzare lo storico degli allenamenti terminati

    -   Visualizzare altri ciclisti sulla mappa

    -   Lanciare una sfida

    -   Accettare (o rifiutare) una sfida e visualizzarne il risultato

Il documento è rivolto a utenti finali, sviluppatori e software testers.

1.2 Scopo {#scopo .Marianna2}
---------

L'applicazione mobile **Social Bike Keeper** deve fornire una
molteplicità di servizi, che vanno dal semplice accesso alla rilevazione
della geoposizione, alla verifica dei vincoli di svolgimento delle sfide
e alla definizione e aggiornamento dello storico degli allenamenti.

### 1.2.1 Definizioni, acronimi e abbreviazioni {#definizioni-acronimi-e-abbreviazioni .Marianna3}

-   *Social Bike Keeper*: nome dell'applicazione

-   *Ciclista:* utente iscritto all'applicazione

-   *Storico:* raccolta dei risultati degli allenamenti terminati

-   *Sfida:* competizione sportiva tra ciclisti

-   *Sfidante:* ciclista che ha lanciato una sfida

-   *Sfidato:* ciclista a cui è destinata la sfida

-   *Archivio:* termine generico per indicare la persistenza di
    informazioni su ciclisti, sfide, ecc.

-   *Vicino:* altri ciclisti individuati sulla mappa

-   *Credenziali:* dati inseriti nella fase di Login per accedere
    all'applicazione

-   *Form:* interfaccia che consente all'utente di inserire i dati

-   *Geoposizione:* posizione geografica del ciclista sulla mappa

-   *Marker:* icona che rappresenta la posizione di un ciclista sulla
    mappa

2 Descrizione generale {#descrizione-generale .Marianna1}
======================

**Social Bike Keeper** deve consentire al ciclista di:

-   Accedere all'applicazione

-   Consultare lo storico dei propri allenamenti

-   Mostrare la propria posizione sulla mappa

-   Effettuare un allenamento

-   Lanciare una sfida

-   Accettare o rifiutare una sfida

-   Effettuare il logout dall'applicazione

2.1 Prospettive del prodotto {#prospettive-del-prodotto .Marianna2}
----------------------------

**Social Bike Keeper** è costituito da:

-   Un dispositivo con sistema operativo Android

-   Un'interfaccia grafica che mette a disposizione degli utenti le
    varie funzionalità dell'applicazione

-   Un database dove sono memorizzate le informazioni relative ai
    ciclisti e alle sfide

3 Requisiti speciali e supplementari {#requisiti-speciali-e-supplementari .Marianna1}
====================================

3.1 Interfaccia utente {#interfaccia-utente .Marianna2}
----------------------

Avviata l'applicazione, l'utente già registrato potrà effettuare il
login, altrimenti potrà procedere alla registrazione.

![](media/image1.png){width="1.8125in"
height="3.2222222222222223in"}**Registrazione**: l'interfaccia consente
l'inserimento di informazione personali: nome, cognome, email e
password. Dopo aver confermato i dati, comparirà un messaggio di
avvenuta registrazione.

![](media/image2.png){width="1.7270833333333333in"
height="3.0701388888888888in"}

**Login**: l'interfaccia consente l'inserimento di email e password. Se
le credenziali sono errate comparirà il messaggio "Login Errato",
altrimenti l'utente potrà accedere alle funzionalità previste
dall'applicazione.

###  {#section .Marianna3}

###  {#section-1 .Marianna3}

###  {#section-2 .Marianna3}

###  {#section-3 .Marianna3}

![](media/image3.png){width="1.7596806649168855in"
height="3.1284919072615924in"}**Sessione d'allenamento**

L'interfaccia consente:

-   di visualizzare la propria geoposizione sulla mappa

-   di iniziare una sessione di allenamento tramite la selezione del
    tasto "Start"

-   di terminare la sessione di allenamento selezionando il tasto "Stop"

-   di sospendere momentaneamente la sessione di allenamento attraverso
    il tasto "Pausa"

-   di visualizzare in real time i chilometri percorsi e le calorie
    bruciate

**Registrazione risultati allenamento**

L'interfaccia consente la visualizzazione dei risultati dell'allenamento
appena terminato.

**Visualizzazione storico allenamenti**

L'interfaccia consente la visualizzazione dei risultati di tutti gli
allenamenti terminati dall'utente.

### 3.1.1 Caratteristiche degli utenti {#caratteristiche-degli-utenti .Marianna3}

Gli utenti destinati all'uso del prodotto Social Bike Keeper sono:

-   Ciclisti dotati di un dispositivo Android che vogliono monitorare i
    propri allenamenti e testare le proprie abilità mettendosi alla
    prova con altri ciclisti.

3.2 Interfaccia con le altre applicazioni {#interfaccia-con-le-altre-applicazioni .Marianna2}
-----------------------------------------

Social Bike Keeper si interfaccia con:

-   Un DBMS MySQL per gestire la persistenza

3.3 Business Rules {#business-rules .Marianna2}
------------------

-   Se un utente non è registrato all'applicazione non può accedere alle
    funzionalità fornite dall'applicazione stessa.

-   Se un utente in fase di registrazione non compila tutti i campi del
    form o inserisce informazioni non valide come un indirizzo email
    senza "*@"* non potrà registrarsi all'applicazione e dovrà ripetere
    l'operazione.

-   Se un utente prova ad accedere all'applicazione senza prima essersi
    registrato, non accederà ad essa.

-   Se un utente registrato inserisce credenziali errate non potrà
    accedere all'applicazione.

4 Requisiti specifici {#requisiti-specifici .Marianna1}
=====================

4.1 Specifiche dei casi d'uso {#specifiche-dei-casi-duso .Marianna2}
-----------------------------

+-----------------------------------+-----------------------------------+
| **Caso d'uso: UC-01**             | **Registrazione**                 |
+===================================+===================================+
| **ATTORI**                        | -   Ciclista                      |
+-----------------------------------+-----------------------------------+
| **INPUT**                         | -   Email                         |
|                                   |                                   |
|                                   | -   Nome                          |
|                                   |                                   |
|                                   | -   Cognome                       |
|                                   |                                   |
|                                   | -   Password                      |
+-----------------------------------+-----------------------------------+
| **PRECONDIZIONI**                 | -   Il ciclista non deve essere   |
|                                   |     già presente nell'archivio    |
|                                   |                                   |
|                                   | -   La connessione a Internet sia |
|                                   |     attiva                        |
+-----------------------------------+-----------------------------------+
| **OUTPUT**                        | -   Il ciclista viene notificato  |
|                                   |     della corretta registrazione  |
+-----------------------------------+-----------------------------------+
| **POSTCONDIZIONI**                | -   Il ciclista è memorizzato     |
|                                   |     all'interno dell'archivio     |
+-----------------------------------+-----------------------------------+
| **SCENARIO PRIMARIO**             | 1.  Il ciclista inserisce le      |
|                                   |     proprie credenziali:          |
|                                   |                                   |
|                                   | <!-- -->                          |
|                                   |                                   |
|                                   | a)  Email                         |
|                                   |                                   |
|                                   | b)  Nome                          |
|                                   |                                   |
|                                   | c)  Cognome                       |
|                                   |                                   |
|                                   | d)  Password                      |
|                                   |                                   |
|                                   | <!-- -->                          |
|                                   |                                   |
|                                   | 1.  Il sistema verifica che il    |
|                                   |     form sia riempito in tutti i  |
|                                   |     suoi campi                    |
|                                   |                                   |
|                                   | 2.  Il sistema verifica che       |
|                                   |     l'email non sia presente      |
|                                   |     nell'archivio                 |
|                                   |                                   |
|                                   | 3.  Il sistema informa il         |
|                                   |     ciclista della corretta       |
|                                   |     registrazione                 |
|                                   |                                   |
|                                   | 4.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | **Il form non viene compilato con |
|                                   | tutte le informazioni richieste** |
|                                   |                                   |
|                                   | i.  Il sistema informa il         |
|                                   |     ciclista con un messaggio di  |
|                                   |     errore                        |
|                                   |                                   |
|                                   | ii. Il caso d'uso riparte dal     |
|                                   |     punto 1                       |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | **L'email è già presente in       |
|                                   | archivio**                        |
|                                   |                                   |
|                                   | i.  Il sistema informa il         |
|                                   |     ciclista con un messaggio di  |
|                                   |     errore                        |
|                                   |                                   |
|                                   | ii. Il caso d'uso riparte dal     |
|                                   |     punto 1 del UC-02             |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | **Uno o più campi del form non    |
|                                   | sono compilati correttamente**    |
|                                   |                                   |
|                                   | i.  Il sistema informa il         |
|                                   |     ciclista con un messaggio di  |
|                                   |     errore                        |
|                                   |                                   |
|                                   | ii. Il caso d'uso riparte dal     |
|                                   |     punto 1                       |
+-----------------------------------+-----------------------------------+

+-----------------------------------+-----------------------------------+
| **Caso d'uso: UC-02**             | **Accesso al sistema**            |
+===================================+===================================+
| **ATTORI**                        | -   Ciclista                      |
+-----------------------------------+-----------------------------------+
| **INPUT**                         | -   Email                         |
|                                   |                                   |
|                                   | -   Password                      |
+-----------------------------------+-----------------------------------+
| **PRECONDIZIONI**                 | -   L'email sia presente          |
|                                   |     nell'archivio dei ciclisti    |
|                                   |                                   |
|                                   | -   La password sia associata     |
|                                   |     all'email                     |
|                                   |                                   |
|                                   | -   La connessione a Internet sia |
|                                   |     attiva                        |
+-----------------------------------+-----------------------------------+
| **OUTPUT**                        | -   Il ciclista viene notificato  |
|                                   |     del corretto accesso          |
|                                   |                                   |
|                                   | -   Il ciclista è abilitato       |
|                                   |     all'utilizzo                  |
|                                   |     dell'applicazione             |
+-----------------------------------+-----------------------------------+
| **POSTCONDIZIONI**                | -   Il ciclista è abilitato       |
|                                   |     all'utilizzo del sistema      |
+-----------------------------------+-----------------------------------+
| **SCENARIO PRIMARIO**             | 1.  Il ciclista inserisce le      |
|                                   |     proprie credenziali:          |
|                                   |                                   |
|                                   | <!-- -->                          |
|                                   |                                   |
|                                   | a)  Email                         |
|                                   |                                   |
|                                   | b)  Password                      |
|                                   |                                   |
|                                   | <!-- -->                          |
|                                   |                                   |
|                                   | 1.  Il sistema verifica che il    |
|                                   |     form sia riempito in tutti i  |
|                                   |     suoi campi                    |
|                                   |                                   |
|                                   | 2.  Il sistema verifica che       |
|                                   |     l'email sia presente          |
|                                   |     nell'archivio                 |
|                                   |                                   |
|                                   | 3.  Il sistema verifica che la    |
|                                   |     password corrisponda          |
|                                   |     all'email inserita            |
|                                   |                                   |
|                                   | 4.  Il sistema informa il         |
|                                   |     ciclista del corretto accesso |
|                                   |                                   |
|                                   | 5.  Il ciclista accede alle       |
|                                   |     funzionalità                  |
|                                   |     dell'applicazione             |
|                                   |                                   |
|                                   | 6.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | **Il form non viene compilato con |
|                                   | tutte le informazioni richieste** |
|                                   |                                   |
|                                   | i.  Il sistema informa il         |
|                                   |     ciclista con un messaggio di  |
|                                   |     errore                        |
|                                   |                                   |
|                                   | ii. Il caso d'uso riparte dal     |
|                                   |     punto 1.                      |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | **La password non corrisponde     |
|                                   | all'email inserita**              |
|                                   |                                   |
|                                   | i.  Il sistema informa il         |
|                                   |     ciclista con un messaggio di  |
|                                   |     errore                        |
|                                   |                                   |
|                                   | ii. Il caso d'uso riparte dal     |
|                                   |     punto 1.                      |
+-----------------------------------+-----------------------------------+

+-----------------------------------+-----------------------------------+
| **Caso d'uso: UC-03**             | **Acquisizione della              |
|                                   | geoposizione**                    |
+===================================+===================================+
| **ATTORI**                        | -   Ciclista                      |
+-----------------------------------+-----------------------------------+
| **INPUT**                         | -   Google Maps                   |
+-----------------------------------+-----------------------------------+
| **PRECONDIZIONI**                 | -   Il ciclista abbia effettuato  |
|                                   |     l'accesso all'applicazione    |
|                                   |                                   |
|                                   | -   Il GPS sia attivo             |
|                                   |                                   |
|                                   | -   La connessione a Internet sia |
|                                   |     attiva                        |
+-----------------------------------+-----------------------------------+
| **OUTPUT**                        | -   Il ciclista viene notificato  |
|                                   |     della sua posizione sulla     |
|                                   |     mappa                         |
+-----------------------------------+-----------------------------------+
| **POSTCONDIZIONI**                | -   Registrazione di una nuova    |
|                                   |     geoposizione all'interno      |
|                                   |     dell'archivio                 |
+-----------------------------------+-----------------------------------+
| **SCENARIO PRIMARIO**             | 1.  Il ciclista accede            |
|                                   |     all'applicazione              |
|                                   |                                   |
|                                   | 2.  Il sistema rileva la          |
|                                   |     geoposizione                  |
|                                   |                                   |
|                                   | 3.  Il sistema registra la        |
|                                   |     geoposizione del ciclista     |
|                                   |                                   |
|                                   | 4.  Il sistema informa il         |
|                                   |     ciclista della sua posizione  |
|                                   |     attraverso un Marker          |
|                                   |                                   |
|                                   | 5.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | i.  Il ciclista non ha attivato   |
|                                   |     il GPS                        |
|                                   |                                   |
|                                   | ii. Il ciclista viene informato   |
|                                   |     che il GPS non è attivo       |
|                                   |                                   |
|                                   | iii. Il caso d'uso termina        |
+-----------------------------------+-----------------------------------+

+-----------------------------------+-----------------------------------+
| **Caso d'uso: UC-04**             | **Sessione di allenamento**       |
+===================================+===================================+
| **ATTORI**                        | -   Ciclista                      |
+-----------------------------------+-----------------------------------+
| **INPUT**                         |                                   |
+-----------------------------------+-----------------------------------+
| **PRECONDIZIONI**                 | -   Il ciclista abbia effettuato  |
|                                   |     l'accesso all'applicazione    |
|                                   |                                   |
|                                   | -   Il ciclista sia stato         |
|                                   |     geolocalizzato                |
|                                   |                                   |
|                                   | -   La connessione a Internet sia |
|                                   |     attiva                        |
+-----------------------------------+-----------------------------------+
| **OUTPUT**                        | -   Il ciclista prende visione    |
|                                   |     dei chilometri percorsi e     |
|                                   |     delle calorie bruciate        |
|                                   |     durante l'allenamento         |
+-----------------------------------+-----------------------------------+
| **POSTCONDIZIONI**                | -   Memorizzazione del risultato  |
|                                   |     dell'allenamento              |
|                                   |     nell'archivio                 |
+-----------------------------------+-----------------------------------+
| **SCENARIO PRIMARIO**             | 1.  Il ciclista accede            |
|                                   |     all'applicazione (vedi        |
|                                   |     **UC-02**)                    |
|                                   |                                   |
|                                   | 2.  Il sistema rileva la          |
|                                   |     geoposizione (vedi **UC-03**) |
|                                   |                                   |
|                                   | 3.  Il ciclista seleziona il      |
|                                   |     tasto Start per iniziare      |
|                                   |     l'allenamento                 |
|                                   |                                   |
|                                   | 4.  Il sistema informa il         |
|                                   |     ciclista real time dei        |
|                                   |     chilometri percorsi e delle   |
|                                   |     calorie bruciate              |
|                                   |                                   |
|                                   | 5.  Il ciclista seleziona il      |
|                                   |     tasto stop per terminare      |
|                                   |     l'allenamento                 |
|                                   |                                   |
|                                   | 6.  Il sistema mostra al ciclista |
|                                   |     i risultati ottenuti          |
|                                   |                                   |
|                                   | 7.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | i.  Il ciclista seleziona il      |
|                                   |     tasto Stop prima di           |
|                                   |     selezionare lo Start          |
|                                   |                                   |
|                                   | ii. Il sistema avvisa il ciclista |
|                                   |     con un messaggio di errore    |
|                                   |                                   |
|                                   | iii. Il caso d'uso riparte dal    |
|                                   |     punto 3                       |
+-----------------------------------+-----------------------------------+

+-----------------------------------+-----------------------------------+
| **Caso d'uso: UC-05**             | **Visualizzazione storico         |
|                                   | allenamenti**                     |
+===================================+===================================+
| **ATTORI**                        | -   Ciclista                      |
+-----------------------------------+-----------------------------------+
| **INPUT**                         |                                   |
+-----------------------------------+-----------------------------------+
| **PRECONDIZIONI**                 | -   Il ciclista abbia effettuato  |
|                                   |     l'accesso all'applicazione    |
|                                   |                                   |
|                                   | -   Il ciclista sia stato         |
|                                   |     geolocalizzato                |
|                                   |                                   |
|                                   | -   La connessione a Internet sia |
|                                   |     attiva                        |
+-----------------------------------+-----------------------------------+
| **OUTPUT**                        | -   Il ciclista prende visione di |
|                                   |     tutti i risultati degli       |
|                                   |     allenamenti da lui completati |
+-----------------------------------+-----------------------------------+
| **POSTCONDIZIONI**                |                                   |
+-----------------------------------+-----------------------------------+
| **SCENARIO PRIMARIO**             | 1.  Il ciclista accede            |
|                                   |     all'applicazione (vedi        |
|                                   |     **UC-02**)                    |
|                                   |                                   |
|                                   | 2.  Il sistema rileva la          |
|                                   |     geoposizione (vedi **UC-03**) |
|                                   |                                   |
|                                   | 3.  Il ciclista seleziona la voce |
|                                   |     "Storico" dal menù            |
|                                   |                                   |
|                                   | 4.  Il sistema mostra al ciclista |
|                                   |     una tabella con tutti i       |
|                                   |     risultati degli allenamenti   |
|                                   |     svolti                        |
|                                   |                                   |
|                                   | 5.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+

4.2 Diagrammi UML {#diagrammi-uml .Marianna2}
-----------------

### 4.2.1 Use Case Diagram {#use-case-diagram .Marianna3}

**Registrazione**

![](media/image4.png){width="7.199031058617673in"
height="2.5208333333333335in"}

**Accesso al sistema**

![](media/image5.png){width="6.895833333333333in"
height="2.4680544619422573in"}

**Acquisizione geoposizione**

![](media/image6.png){width="6.864583333333333in"
height="2.399040901137358in"}

**Sessione d'allenamento**

![](media/image7.png){width="6.979166666666667in"
height="2.4992957130358704in"}

**Visualizzazione storico allenamenti**

![](media/image8.png){width="5.351999125109361in"
height="2.280985345581802in"}

### 4.2.2 Activity Diagram {#activity-diagram .Marianna3}

**Registrazione**

![](media/image9.png){width="5.421172353455818in" height="8.46875in"}

**Accesso al sistema**

![](media/image10.png){width="4.014095581802275in"
height="8.385416666666666in"}

**Acquisizione geoposizione**

![](media/image11.png){width="4.395833333333333in"
height="4.295402449693788in"}

**Sessione d'allenamento**

![](media/image12.png){width="3.90625in" height="3.7508869203849518in"}

**Visualizzazione storico allenamenti**

![](media/image13.png){width="3.5759995625546805in"
height="3.5268536745406824in"}
