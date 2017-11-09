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

![](media/image1.png){width="1.7598425196850394in"
height="3.1286089238845145in"}[]{#_Toc498009144
.anchor}**Registrazione**: l'interfaccia consente l'inserimento di
informazione personali: nome, cognome, email e password. Dopo aver
confermato i dati, comparirà un messaggio di avvenuta registrazione.

![](media/image2.png){width="1.7598425196850394in"
height="3.1283737970253718in"}

[]{#_Toc498009145 .anchor}**Login**: l'interfaccia consente
l'inserimento di email e password. Se le credenziali sono errate
comparirà il messaggio "Login Errato", altrimenti l'utente potrà
accedere alle funzionalità previste dall'applicazione.

###  {#section .Marianna3}

###  {#section-1 .Marianna3}

###  {#section-2 .Marianna3}

###  {#section-3 .Marianna3}

[]{#_Toc498009146
.anchor}![](media/image3.png){width="1.7596806649168855in"
height="3.1284919072615924in"}Sessione d'allenamento

L'interfaccia consente:

-   di visualizzare la propria geoposizione sulla mappa

-   di iniziare una sessione di allenamento tramite la selezione del
    tasto "Start"

-   di terminare la sessione di allenamento selezionando il tasto "Stop"

-   di sospendere momentaneamente la sessione di allenamento attraverso
    il tasto "Pausa"

-   di visualizzare in real time i chilometri percorsi e le calorie
    bruciate

![](media/image4.png){width="1.7598425196850394in"
height="3.1288440507436572in"}

[]{#_Toc498009147 .anchor}Registrazione risultati allenamento

L'interfaccia consente la visualizzazione dei risultati dell'allenamento
appena terminato.

[]{#_Toc498009148
.anchor}![](media/image5.png){width="1.7598425196850394in"
height="3.1293416447944007in"}Visualizzazione storico allenamenti

L'interfaccia consente la visualizzazione dei risultati di tutti gli
allenamenti terminati dall'utente.

![](media/image6.png){width="1.7597222222222222in"
height="3.1284722222222223in"}

[]{#_Toc498009149 .anchor}Ricerca ciclisti da sfidare

L'interfaccia mostra una mappa con i marker dei ciclisti loggati in quel
momento e dà la possibilità di lanciare una sfida al ciclista scelto
selezionando il marker corrispondente.

[]{#_Toc498009150 .anchor}La sfida

L'interfaccia consente di visualizzare un countdown della durata scelta
in fase di lancio della sfida, i chilometri percorsi, le calorie
bruciate, il percorso sulla mappa e un messaggio che informa il ciclista
quando la sfida è stata completata.

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

-   Le sfide possono durare o 60 o 90 minuti.

-   Ogni sfida comprende non più di due partecipanti.

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
| **SCENARIO ALTERNATIVO**          | > **Il GPS non è stato attivato** |
|                                   |                                   |
|                                   | i.  Il ciclista non ha attivato   |
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
| **SCENARIO ALTERNATIVO**          | > **Selezione prematura del tasto |
|                                   | > Stop**                          |
|                                   |                                   |
|                                   | i.  Il ciclista seleziona il      |
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

+-----------------------------------+-----------------------------------+
| **Caso d'uso: UC-06**             | **Lancio di una sfida**           |
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
|                                   |                                   |
|                                   | -   È presente almeno un altro    |
|                                   |     ciclista loggato              |
+-----------------------------------+-----------------------------------+
| **OUTPUT**                        | -   Il ciclista lancia una sfida  |
|                                   |     ad un altro ciclista          |
+-----------------------------------+-----------------------------------+
| **POSTCONDIZIONI**                | -   Il ciclista che lancia la     |
|                                   |     sfida diventa *sfidante*      |
|                                   |                                   |
|                                   | -   Il ciclista che lancia la     |
|                                   |     sfida diventa *sfidato*       |
|                                   |                                   |
|                                   | -   Memorizzazione della sfida    |
|                                   |     nell'archivio                 |
+-----------------------------------+-----------------------------------+
| **SCENARIO PRIMARIO**             | 1.  Il ciclista accede            |
|                                   |     all'applicazione (vedi        |
|                                   |     **UC-02**)                    |
|                                   |                                   |
|                                   | 2.  Il sistema rileva la          |
|                                   |     geoposizione (vedi **UC-03**) |
|                                   |                                   |
|                                   | 3.  Il ciclista seleziona la voce |
|                                   |     "Sfida" dal menù              |
|                                   |                                   |
|                                   | 4.  Il sistema mostra al ciclista |
|                                   |     una mappa con i marker        |
|                                   |     corrispondenti ai ciclisti    |
|                                   |     loggati                       |
|                                   |                                   |
|                                   | 5.  Il ciclista sceglie un marker |
|                                   |     e seleziona "Sfidami"         |
|                                   |                                   |
|                                   | 6.  Il ciclista sceglie la durata |
|                                   |     della sfida                   |
|                                   |                                   |
|                                   | 7.  Il sistema informa lo         |
|                                   |     sfidante che la sfida è stata |
|                                   |     lanciata correttamente        |
|                                   |                                   |
|                                   | 8.  Il sistema mostra al ciclista |
|                                   |     una notifica di accettazione  |
|                                   |                                   |
|                                   | 9.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | > **La sfida viene rifiutata**    |
|                                   |                                   |
|                                   | i.  Il sistema mostra al ciclista |
|                                   |     una notifica di rifiuto della |
|                                   |     sfida                         |
|                                   |                                   |
|                                   | ii. La sfida viene cancellata     |
|                                   |     dall'archivio                 |
|                                   |                                   |
|                                   | iii. Il caso d'uso termina        |
+-----------------------------------+-----------------------------------+

+-----------------------------------+-----------------------------------+
| **Caso d'uso: UC-07**             | **Accettazione di una sfida**     |
+===================================+===================================+
| **ATTORI**                        | -   Sfidato                       |
+-----------------------------------+-----------------------------------+
| **INPUT**                         |                                   |
+-----------------------------------+-----------------------------------+
| **PRECONDIZIONI**                 | -   Lo sfidato abbia effettuato   |
|                                   |     l'accesso all'applicazione    |
|                                   |                                   |
|                                   | -   Lo sfidato sia stato          |
|                                   |     geolocalizzato                |
|                                   |                                   |
|                                   | -   La connessione a Internet sia |
|                                   |     attiva                        |
+-----------------------------------+-----------------------------------+
| **OUTPUT**                        | -   Lo sfidato inizia la sfida    |
+-----------------------------------+-----------------------------------+
| **POSTCONDIZIONI**                | -   Lo stato della sfida in       |
|                                   |     archivio viene modificato     |
+-----------------------------------+-----------------------------------+
| **SCENARIO PRIMARIO**             | 1.  Lo sfidato accede             |
|                                   |     all'applicazione (vedi        |
|                                   |     **UC-02**)                    |
|                                   |                                   |
|                                   | 2.  Il sistema rileva la          |
|                                   |     geoposizione (vedi **UC-03**) |
|                                   |                                   |
|                                   | 3.  Il sistema mostra allo        |
|                                   |     sfidato una notifica di una   |
|                                   |     sfida lanciatagli             |
|                                   |                                   |
|                                   | 4.  Lo sfidato accetta la sfida   |
|                                   |                                   |
|                                   | 5.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | > **Lo sfidato rifiuta la sfida** |
|                                   |                                   |
|                                   | i.  Lo sfidato rifiuta la sfida   |
|                                   |     lanciatagli                   |
|                                   |                                   |
|                                   | ii. Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+

+-----------------------------------+-----------------------------------+
| **Caso d'uso: UC-08**             | **La sfida**                      |
+===================================+===================================+
| **ATTORI**                        | -   Sfidante                      |
|                                   |                                   |
|                                   | -   Sfidato                       |
+-----------------------------------+-----------------------------------+
| **INPUT**                         | -   Lo sfidato deve accettare la  |
|                                   |     sfida                         |
|                                   |                                   |
|                                   | -   Lo sfidante deve cliccare     |
|                                   |     sulla notifica                |
+-----------------------------------+-----------------------------------+
| **PRECONDIZIONI**                 | -   Lo sfidante e lo sfidato      |
|                                   |     abbiano effettuato l'accesso  |
|                                   |     all'applicazione              |
|                                   |                                   |
|                                   | -   Lo sfidante e lo sfidato      |
|                                   |     siano stati geolocalizzati    |
|                                   |                                   |
|                                   | -   La connessione a Internet sia |
|                                   |     attiva                        |
+-----------------------------------+-----------------------------------+
| **OUTPUT**                        | -   Lo sfidante e lo sfidato      |
|                                   |     ricevono il risultato della   |
|                                   |     sfida                         |
+-----------------------------------+-----------------------------------+
| **POSTCONDIZIONI**                | -   Il risultato della sfida      |
|                                   |     viene memorizzato             |
|                                   |     nell'archivio                 |
+-----------------------------------+-----------------------------------+
| **SCENARIO PRIMARIO**             | 1.  Lo sfidante e lo sfidato      |
|                                   |     accedono all'applicazione     |
|                                   |     (vedi **UC-02**)              |
|                                   |                                   |
|                                   | 2.  Il sistema rileva la          |
|                                   |     geoposizione di entrambi      |
|                                   |     (vedi **UC-03**)              |
|                                   |                                   |
|                                   | 3.  Sfida lanciata (vedi          |
|                                   |     **UC-07**)                    |
|                                   |                                   |
|                                   | 4.  Lo sfidato inizia la sfida    |
|                                   |                                   |
|                                   | 5.  Lo sfidante clicca sulla      |
|                                   |     notifica e inizia la sfida    |
|                                   |                                   |
|                                   | 6.  Lo sfidato termina la sfida   |
|                                   |                                   |
|                                   | 7.  Lo sfidante termina la sfida  |
|                                   |                                   |
|                                   | 8.  Il sistema informa sfidante e |
|                                   |     sfidato dell'esito della      |
|                                   |     sfida con una notifica        |
|                                   |                                   |
|                                   | 9.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | > **Lo sfidato non completa la    |
|                                   | > sfida**                         |
|                                   |                                   |
|                                   | i.  Lo sfidato non completa la    |
|                                   |     sfida                         |
|                                   |                                   |
|                                   | ii. Il sistema informa lo         |
|                                   |     sfidante che ha vinto la      |
|                                   |     sfida                         |
|                                   |                                   |
|                                   | iii. Il caso d'uso termina        |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | > **Lo sfidante non completa la   |
|                                   | > sfida**                         |
|                                   |                                   |
|                                   | i.  Lo sfidante non completa la   |
|                                   |     sfida                         |
|                                   |                                   |
|                                   | ii. Il sistema informa lo sfidato |
|                                   |     che ha vinto la sfida         |
|                                   |                                   |
|                                   | iii. Il caso d'uso termina        |
+-----------------------------------+-----------------------------------+

4.2 Diagrammi UML {#diagrammi-uml .Marianna2}
-----------------

### 4.2.1 Use Case Diagram {#use-case-diagram .Marianna3}

[]{#_Toc498009158 .anchor}Registrazione

![](media/image7.png){width="7.198611111111111in"
height="2.4959995625546805in"}

[]{#_Toc498009159 .anchor}Accesso al sistema

![](media/image8.png){width="6.895833333333333in"
height="2.4680544619422573in"}

[]{#_Toc498009160 .anchor}Acquisizione geoposizione

![](media/image9.png){width="6.864583333333333in"
height="2.399040901137358in"}

[]{#_Toc498009161 .anchor}Sessione d'allenamento

![](media/image10.png){width="6.979166666666667in"
height="2.4992957130358704in"}

[]{#_Toc498009162 .anchor}Visualizzazione storico allenamenti

![](media/image11.png){width="5.351999125109361in"
height="2.280985345581802in"}

[]{#_Toc498009163 .anchor}Lancio di una sfida

![](media/image12.png){width="6.2in" height="2.186895231846019in"}

[]{#_Toc498009164 .anchor}Accettazione di una sfida

![](media/image13.png){width="6.33599956255468in"
height="2.2870199037620296in"}

### 4.2.2 Activity Diagram {#activity-diagram .Marianna3}

[]{#_Toc498009166 .anchor}Registrazione

![](media/image14.png){width="5.421172353455818in" height="8.46875in"}

[]{#_Toc498009167 .anchor}Accesso al sistema

![](media/image15.png){width="4.014095581802275in"
height="8.385416666666666in"}

[]{#_Toc498009168 .anchor}Acquisizione geoposizione

![](media/image16.png){width="4.395833333333333in"
height="4.295402449693788in"}

[]{#_Toc498009169 .anchor}Sessione d'allenamento

![](media/image17.png){width="3.90625in" height="3.7508869203849518in"}

[]{#_Toc498009170 .anchor}Visualizzazione storico allenamenti

![](media/image18.png){width="3.5759995625546805in"
height="3.5268536745406824in"}

[]{#_Toc498009171 .anchor}Lancio di una sfida

![](media/image19.png){width="2.88in" height="4.572731846019248in"}

[]{#_Toc498009172 .anchor}Accettazione di una sfida

![](media/image20.png){width="2.7313527996500437in"
height="4.37599956255468in"}

### 4.2.3 Sequence Diagram {#sequence-diagram .Marianna3}

[]{#_Toc498009174 .anchor}Accesso al sistema

![](media/image21.png){width="5.823999343832021in"
height="3.821330927384077in"}

[]{#_Toc498009175 .anchor}Registrazione

![](media/image22.png){width="4.855555555555555in"
height="3.231999125109361in"}

[]{#_Toc498009176 .anchor}Acquisizione geoposizione

![](media/image23.png){width="4.967361111111111in"
height="2.191999125109361in"}

[]{#_Toc498009177 .anchor}Sessione d'allenamento

![](media/image24.png){width="4.3277777777777775in"
height="2.935999562554681in"}

[]{#_Toc498009178 .anchor}La sfida -- lato sfidante

![](media/image25.png){width="6.34375in" height="7.193359580052493in"}

[]{#_Toc498009179 .anchor}La sfida -- lato sfidato

![](media/image26.png){width="6.010416666666667in"
height="6.0605030621172356in"}

5 Testing {#testing .Marianna1}
=========

5.1 Testing funzionale {#testing-funzionale .Marianna2}
----------------------

  []{#_Toc498009182 .anchor}Registrazione                                                                                                                    
  ----------------------------------------- ------------------------------------------------------- ------ --------- ---------- ---------------------------- ----------------------------
  ID                                        Email                                                   Nome   Cognome   Password   Valore atteso                Output
  \#1                                       [[sara@gmail.com]{.underline}](mailto:sara@gmail.com)   sara   caruso    sara       "Utente esistente"           "Utente esistente"
  \#2                                       [[jim@gmail.com]{.underline}](mailto:jim@gmail.com)     jim    jim       jim        "Registrazione avvenuta"     "Registrazione avvenuta"
  \#3                                       null@null                                               null   null      null       "Dati inseriti non validi"   "Dati inseriti non validi"
  \#4                                       jim                                                                                 "Dati inseriti non validi"   "Dati inseriti non validi"

  []{#_Toc498009183 .anchor}Accesso al sistema                                                                                                  
  ---------------------------------------------- ------------------------------------------------------- ---------- --------------------------- ---------------------------
  ID                                             Email                                                   Password   Valore atteso               Output
  \#1                                            [[sara@gmail.com]{.underline}](mailto:sara@gmail.com)   sara       "Benvenuto"                 "Benvenuto"
  \#2                                                                                                               "ATTENZIONE login errato"   "ATTENZIONE login errato"
  \#3                                            [[sara@gmail.com]{.underline}](mailto:sara@gmail.com)   aras       "ATTENZIONE login errato"   "ATTENZIONE login errato"
  \#4                                            [[aras@gmail.com]{.underline}](mailto:aras@gmail.com)   sara       "ATTENZIONE login errato"   "ATTENZIONE login errato"

+-------------+-------------+-------------+-------------+-------------+
| []{#_Toc498 |
| 009184      |
| .anchor}Ses |
| sione       |
| d'allenamen |
| to          |
+=============+=============+=============+=============+=============+
| ID          | Operazione  | Operazione  | Valore      | Output      |
|             | \#1         | \#2         | atteso      |             |
+-------------+-------------+-------------+-------------+-------------+
| \#1         | Selezione   | Selezione   | Parte il    | Parte il    |
|             | tasto Start | tasto Stop  | cronometro  | cronometro  |
|             |             |             | Valore      | Valore      |
|             |             |             | Chilometri  | Chilometri  |
|             |             |             | e Valore    | e Valore    |
|             |             |             | Calorie     | Calorie     |
|             |             |             | sono        | sono        |
|             |             |             | visibili    | visibili    |
|             |             |             |             |             |
|             |             |             | Visualizza  | Visualizza  |
|             |             |             | i risultati | i risultati |
+-------------+-------------+-------------+-------------+-------------+
| \#2         | Selezione   |             | "Devi       | "Devi       |
|             | tasto Stop  |             | premere     | premere     |
|             |             |             | Start prima | Start prima |
|             |             |             | di iniziare | di iniziare |
|             |             |             | l'allenamen | l'allenamen |
|             |             |             | to"         | to"         |
+-------------+-------------+-------------+-------------+-------------+

  []{#_Toc498009185 .anchor}Lancio di una sfida                                                               
  ----------------------------------------------- ------------------------------------ ---------------------- ----------------------
  ID                                              Operazione \#1                       Valore atteso          Output
  \#1                                             Selezione marker sfidante            Visualizza "Sei qui"   Visualizza "Sei qui"
  \#2                                             Selezione marker possibile sfidato   Visualizza "Sfidami"   Visualizza "Sfidami"
