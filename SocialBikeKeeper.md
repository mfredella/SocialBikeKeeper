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
height="3.1286089238845145in"}[]{#_Toc498440549
.anchor}**Registrazione**: l'interfaccia consente l'inserimento di
informazione personali: nome, cognome, email e password. Dopo aver
confermato i dati, comparirà un messaggio di avvenuta registrazione.

![](media/image2.png){width="1.7598425196850394in"
height="3.1283737970253718in"}

[]{#_Toc498440550 .anchor}**Login**: l'interfaccia consente
l'inserimento di email e password. Se le credenziali sono errate
comparirà il messaggio "Login Errato", altrimenti l'utente potrà
accedere alle funzionalità previste dall'applicazione.

###  {#section .Marianna3}

###  {#section-1 .Marianna3}

###  {#section-2 .Marianna3}

###  {#section-3 .Marianna3}

[]{#_Toc498440551
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

[]{#_Toc498440552 .anchor}Registrazione risultati allenamento

L'interfaccia consente la visualizzazione dei risultati dell'allenamento
appena terminato.

[]{#_Toc498440553
.anchor}![](media/image5.png){width="1.7598425196850394in"
height="3.1293416447944007in"}Visualizzazione storico allenamenti

L'interfaccia consente la visualizzazione dei risultati di tutti gli
allenamenti terminati dall'utente.

![](media/image6.png){width="1.7597222222222222in"
height="3.1284722222222223in"}

[]{#_Toc498440554 .anchor}Ricerca ciclisti da sfidare

L'interfaccia mostra una mappa con i marker dei ciclisti loggati in quel
momento e dà la possibilità di lanciare una sfida al ciclista scelto
selezionando il marker corrispondente.

[]{#_Toc498440555 .anchor}La sfida

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
|                                   | 1.  Il ciclista legge il          |
|                                   |     messaggio di avvenuta         |
|                                   |     registrazione                 |
|                                   |                                   |
|                                   | 2.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | **Il form non viene compilato con |
|                                   | tutte le informazioni richieste** |
|                                   |                                   |
|                                   | i.  Il ciclista legge un          |
|                                   |     messaggio di errore           |
|                                   |                                   |
|                                   | ii. Il caso d'uso riparte dal     |
|                                   |     punto 1                       |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | **L'email è già presente in       |
|                                   | archivio**                        |
|                                   |                                   |
|                                   | i.  Il ciclista legge un          |
|                                   |     messaggio di errore           |
|                                   |                                   |
|                                   | ii. Il caso d'uso riparte dal     |
|                                   |     punto 1 del UC-02             |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | **Uno o più campi del form non    |
|                                   | sono compilati correttamente**    |
|                                   |                                   |
|                                   | i.  Il ciclista legge un          |
|                                   |     messaggio di errore           |
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
|                                   | 1.  Il ciclista accede alle       |
|                                   |     funzionalità                  |
|                                   |     dell'applicazione             |
|                                   |                                   |
|                                   | 2.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | **Il form non viene compilato con |
|                                   | tutte le informazioni richieste** |
|                                   |                                   |
|                                   | i.  Il ciclista legge un          |
|                                   |     messaggio di errore           |
|                                   |                                   |
|                                   | ii. Il caso d'uso riparte dal     |
|                                   |     punto 1.                      |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | **La password non corrisponde     |
|                                   | all'email inserita**              |
|                                   |                                   |
|                                   | i.  Il ciclista legge un          |
|                                   |     messaggio di errore           |
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
|                                   | 2.  Il ciclista vede un marker    |
|                                   |     relativo alla sua posizione   |
|                                   |     sulla mappa                   |
|                                   |                                   |
|                                   | 3.  Il caso d'uso termina         |
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
|                                   | 2.  Il ciclista viene             |
|                                   |     geolocalizzato (vedi          |
|                                   |     **UC-03**)                    |
|                                   |                                   |
|                                   | 3.  Il ciclista seleziona il      |
|                                   |     tasto Start per iniziare      |
|                                   |     l'allenamento                 |
|                                   |                                   |
|                                   | 4.  Il ciclista vede cambiare in  |
|                                   |     real time i chilometri        |
|                                   |     percorsi e le calorie         |
|                                   |     bruciate                      |
|                                   |                                   |
|                                   | 5.  Il ciclista seleziona il      |
|                                   |     tasto stop per terminare      |
|                                   |     l'allenamento                 |
|                                   |                                   |
|                                   | 6.  Il ciclista vede i risultati  |
|                                   |     ottenuti                      |
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
|                                   | <!-- -->                          |
|                                   |                                   |
|                                   | i.  Il ciclista legge un          |
|                                   |     messaggio di errore           |
|                                   |                                   |
|                                   | <!-- -->                          |
|                                   |                                   |
|                                   | i.  Il caso d'uso riparte dal     |
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
|                                   | 2.  Il ciclista viene             |
|                                   |     geolocalizzato (vedi          |
|                                   |     **UC-03**)                    |
|                                   |                                   |
|                                   | 3.  Il ciclista seleziona la voce |
|                                   |     "Storico" dal menù            |
|                                   |                                   |
|                                   | 4.  Il ciclista prende visione di |
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
|                                   | 2.  Il ciclista viene             |
|                                   |     geolocalizzato (vedi          |
|                                   |     **UC-03**)                    |
|                                   |                                   |
|                                   | 3.  Il ciclista seleziona la voce |
|                                   |     "Sfida" dal menù              |
|                                   |                                   |
|                                   | 4.  Il ciclista prende visione    |
|                                   |     dei marker sulla mappa        |
|                                   |     corrispondenti ai ciclisti    |
|                                   |     loggati                       |
|                                   |                                   |
|                                   | 5.  Il ciclista sceglie un marker |
|                                   |     e seleziona "Sfidami"         |
|                                   |                                   |
|                                   | 6.  Il ciclista sceglie la durata |
|                                   |     della sfida                   |
|                                   |                                   |
|                                   | 7.  Il ciclista riceve una        |
|                                   |     notifica di accettazione      |
|                                   |                                   |
|                                   | 8.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | > **La sfida viene rifiutata**    |
|                                   |                                   |
|                                   | i.  Il ciclista riceve una        |
|                                   |     notifica di rifiuto della     |
|                                   |     sfida                         |
|                                   |                                   |
|                                   | ii. Il caso d'uso termina         |
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
|                                   | 2.  Lo sfidato viene              |
|                                   |     geolocalizzato (vedi          |
|                                   |     **UC-03**)                    |
|                                   |                                   |
|                                   | 3.  Lo sfidato riceve una         |
|                                   |     notifica di una sfida         |
|                                   |     lanciatagli                   |
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
|                                   | 2.  Lo sfidante e lo sfidato      |
|                                   |     vengono geolocalizzati (vedi  |
|                                   |     **UC-03**)                    |
|                                   |                                   |
|                                   | 3.  Lo sfidato inizia la sfida    |
|                                   |                                   |
|                                   | 4.  Lo sfidante clicca sulla      |
|                                   |     notifica e inizia la sfida    |
|                                   |                                   |
|                                   | 5.  Lo sfidato termina la sfida   |
|                                   |                                   |
|                                   | 6.  Lo sfidante termina la sfida  |
|                                   |                                   |
|                                   | 7.  Lo sfidante e lo sfidato      |
|                                   |     ricevono una notifica con     |
|                                   |     l'esito della sfida           |
|                                   |                                   |
|                                   | 8.  Il caso d'uso termina         |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | > **Lo sfidato non completa la    |
|                                   | > sfida**                         |
|                                   |                                   |
|                                   | i.  Lo sfidato non completa la    |
|                                   |     sfida                         |
|                                   |                                   |
|                                   | ii. Lo sfidante riceve una        |
|                                   |     notifica di vittoria a        |
|                                   |     tavolino                      |
|                                   |                                   |
|                                   | iii. Il caso d'uso termina        |
+-----------------------------------+-----------------------------------+
| **SCENARIO ALTERNATIVO**          | > **Lo sfidante non completa la   |
|                                   | > sfida**                         |
|                                   |                                   |
|                                   | i.  Lo sfidante non completa la   |
|                                   |     sfida                         |
|                                   |                                   |
|                                   | ii. Lo sfidato riceve una         |
|                                   |     notifica di vittoria a        |
|                                   |     tavolino                      |
|                                   |                                   |
|                                   | iii. Il caso d'uso termina        |
+-----------------------------------+-----------------------------------+

4.2 Diagrammi UML {#diagrammi-uml .Marianna2}
-----------------

### 4.2.1 Sequence Diagram {#sequence-diagram .Marianna3}

[]{#_Toc498440563 .anchor}Accesso al sistema

![](media/image7.png){width="5.823999343832021in"
height="3.821330927384077in"}

[]{#_Toc498440564 .anchor}Registrazione

![](media/image8.png){width="4.855555555555555in"
height="3.231999125109361in"}

[]{#_Toc498440565 .anchor}Acquisizione geoposizione

![](media/image9.png){width="4.967361111111111in"
height="2.191999125109361in"}

[]{#_Toc498440566 .anchor}Sessione d'allenamento

![](media/image10.png){width="4.3277777777777775in"
height="2.935999562554681in"}

[]{#_Toc498440567 .anchor}La sfida -- lato sfidante

![](media/image11.png){width="6.34375in" height="7.193359580052493in"}

[]{#_Toc498440568 .anchor}La sfida -- lato sfidato

![](media/image12.png){width="6.010416666666667in"
height="6.0605030621172356in"}

### 4.2.2 StateMachine Diagram {#statemachine-diagram .Marianna3}

![](media/image13.png){width="6.660753499562555in"
height="4.885416666666667in"}

### 4.2.3 Class Diagram {#class-diagram .Marianna3}

![](media/image14.png){width="6.68in" height="7.371729002624672in"}

### 4.2.4 Deployment Diagram {#deployment-diagram .Marianna3}

![](media/image15.png){width="6.72799978127734in"
height="3.7917191601049867in"}

5 Testing {#testing .Marianna1}
=========

Black box testing {#black-box-testing .Marianna2}
-----------------

Il testing black box è stato effettuato creando per ogni Activity un
caso di Test e simulando il comportamento dell'applicazione in risposta
agli input dell'utente tramite apposite librerie quali: Espresso,
UiAnimator e ActivityInstrumentationTestCase2.

  []{#_Toc498440572 .anchor}Registrazione                                                                                                                                                   
  ----------------------------------------- ---------------------------------- -------------------------------- ------------- -------------- ----------------- ---------------------------- ----------------------------
  **Choice**                                **Categories**                     **Enviroment characteristics**                                                                               
                                            **Email**                          **Nome**                         **Cognome**   **Password**   **GPS/Network**   **Valore atteso**            **Output**
  \#1                                       "[<sara@gmail.com>"]{.underline}   "sara"                           "caruso"      "sara"         Attivo/Attivo     "Utente esistente"           "Utente esistente"
  \#2                                       "[<jim@gmail.com>"]{.underline}    "jim"                            "jim"         "jim"          Attivo/Attivo     "Registrazione avvenuta"     "Registrazione avvenuta"
  \#3                                       "null@null"                        "null"                           "null"        "null"         Attivo/Attivo     "Dati inseriti non validi"   "Dati inseriti non validi"
  \#4                                       "jim"                              ""                               ""            ""             Attivo/Attivo     "Dati inseriti non validi"   "Dati inseriti non validi"

  []{#_Toc498440573 .anchor}Accesso al sistema                                                                                                                     
  ---------------------------------------------- ---------------------------------- -------------------------------- ----------------- --------------------------- ---------------------------
  **Choice**                                     **Categories**                     **Enviroment characteristics**                                                 
                                                 Email                              Password                         **GPS/Network**   Valore atteso               Output
  \#1                                            "[<sara@gmail.com>"]{.underline}   "sara"                           Attivo/Attivo     "Benvenuto"                 "Benvenuto"
  \#2                                            ""                                 ""                               Attivo/Attivo     "ATTENZIONE login errato"   "ATTENZIONE login errato"
  \#3                                            "[<sara@gmail.com>"]{.underline}   "aras"                           Attivo/Attivo     "ATTENZIONE login errato"   "ATTENZIONE login errato"
  \#4                                            "[<aras@gmail.com>"]{.underline}   "sara"                           Attivo/Attivo     "ATTENZIONE login errato"   "ATTENZIONE login errato"

  []{#_Toc498440574 .anchor}Sessione d'allenamento                                                                                                                                                     
  -------------------------------------------------- ----------------------- -------------------------------- ----------------- ---------------------------------------------------------------------- ----------------------------------------------------------------------
  **Choice**                                         **Categories**          **Enviroment characteristics**                                                                                            
                                                     **Operazione \#1**      **Operazione \#2**               **GPS/Network**   **Valore atteso**                                                      **Output**
  \#1                                                Selezione tasto Start                                    Attivo/Attivo     Parte il cronometro Valore Chilometri e Valore Calorie sono visibili   Parte il cronometro Valore Chilometri e Valore Calorie sono visibili
  \#2                                                Selezione tasto Start   Selezione tasto Stop             Attivo/Attivo     Visualizza i risultati                                                 Visualizza i risultati
  \#3                                                Selezione tasto Stop                                     Attivo/Attivo     "Devi premere Start prima di iniziare l'allenamento"                   "Devi premere Start prima di iniziare l'allenamento"

  []{#_Toc498440575 .anchor}Lancio di una sfida                                                                                                 
  ----------------------------------------------- ------------------------------------ --------------------------------- ---------------------- ----------------------
  **Choice**                                      **Categories**                       **Enviroments characteristics**                          
                                                  **Operazione \#1**                   **GPS/Network**                   **Valore atteso**      **Output**
  \#1                                             Selezione marker sfidante            Attivo/Attivo                     Visualizza "Sei qui"   Visualizza "Sei qui"
  \#2                                             Selezione marker possibile sfidato   Attivo/Attivo                     Visualizza "Sfidami"   Visualizza "Sfidami"

  []{#_Toc498440576 .anchor}Challenge                                                                                      
  ------------------------------------- -------------------------------- ------------------------------------------------- -------------------------------------------------
  **Choice**                            **Categories**                                                                     
                                        **Operazione \#1**               **Valore atteso**                                 **Output**
  \#1                                   Visualizza notifica              "Hai una nuova sfida di 60 minuti da:"            "Hai una nuova sfida di 60 minuti da:"
  \#2                                   Selezione notifica               "Accetti la Sfida?"                               "Accetti la Sfida?"
  \#3                                   Seleziona "NO" (Rifiuta sfida)   Visualizza schermata per sessione d'allenamento   Visualizza schermata per sessione d'allenamento
  \#4                                   Seleziona "SI" (Accetta sfida)   "Sfida accettata, activity da implementare"       "Sfida accettata, activity da implementare"

Coverage test {#coverage-test .Marianna2}
-------------

Al fine di disporre di una valutazione quantitativa del livello di
copertura dei test, è stato utilizzato il tool *Jacoco*. Esso ci ha
fornito un report con i dettagli sulla percentuale delle righe di codice
coperte dai test e, più precisamente, evidenzia in verde e in rosso
rispettivamente le righe di codice coperte o meno.
