package ro.ase.eu.aslapplication.intrebariQuiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Ileana Gheorghe on 6/10/2018.
 */

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyDatabaseQuiz.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        final String SQL_CREATE_TABLE="CREATE TABLE "+
                QuizContract.QuestionsTable.TABLE_NAME + " ( "+
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ANSWER_NR + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ULRIMAGE + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_CATEGORY + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_TABLE);
        //fill table
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable(){
        Question q1 = new Question("În imagine este reprezentat numărul : ",
                "10", "20", "30", 1, "https://ileanadaniela19.000webhostapp.com/numbers/10.jpg", Question.CATEGORY_NUMBERE);
        addQuestion(q1);

        Question q2 = new Question("În imagine este reprezentat numărul : ","5", "6", "7", 2, "https://ileanadaniela19.000webhostapp.com/numbers/6.jpg ",Question.CATEGORY_NUMBERE);
        addQuestion(q2);

        Question q3 = new Question("În imagine este reprezentat numărul: ","6","9","10", 2, "https://ileanadaniela19.000webhostapp.com/numbers/9.jpg" ,Question.CATEGORY_NUMBERE);
        addQuestion(q3);

        Question q4 = new Question("În imagine este reprezentat numărul: ","12","13","18", 3,"https://ileanadaniela19.000webhostapp.com/numbers/18.jpg", Question.CATEGORY_NUMBERE);
        addQuestion(q4);

        Question q5 = new Question("În imagine este reprezentat numărul: ","12","22","23", 2, "https://ileanadaniela19.000webhostapp.com/numbers/22.jpg" , Question.CATEGORY_NUMBERE);
        addQuestion(q5);

        Question q6 = new Question("În imagine este reprezentat numărul: ","11","21","1", 1, "https://ileanadaniela19.000webhostapp.com/numbers/11.jpg" , Question.CATEGORY_NUMBERE);
        addQuestion(q6);

        Question q7 = new Question("În imagine este reprezentat numărul: ","12","14","16", 2, "https://ileanadaniela19.000webhostapp.com/numbers/14.jpg", Question.CATEGORY_NUMBERE);
        addQuestion(q7);

        Question q8 = new Question("În imagine este reprezentat numărul: ","14","15","16", 3, "https://ileanadaniela19.000webhostapp.com/numbers/16.jpg", Question.CATEGORY_NUMBERE);
        addQuestion(q8);

        Question q9 = new Question("În imagine este reprezentat numărul: ","9","19","10", 2, "https://ileanadaniela19.000webhostapp.com/numbers/19.jpg", Question.CATEGORY_NUMBERE);
        addQuestion(q9);

        Question q10 = new Question("În imagine este reprezentat numărul: ","7","6","8", 1, "https://ileanadaniela19.000webhostapp.com/numbers/7.jpg", Question.CATEGORY_NUMBERE);
        addQuestion(q10);


        Question q11 = new Question("În imagine este reprezentat numărul: ","11","12","15", 3, "https://ileanadaniela19.000webhostapp.com/numbers/15.jpg", Question.CATEGORY_NUMBERE);
        addQuestion(q11);

        Question q12 = new Question("În imagine este reprezentat numărul: ","12","13","18", 1, "https://ileanadaniela19.000webhostapp.com/numbers/12.jpg", Question.CATEGORY_NUMBERE);
        addQuestion(q12);


        Question q13 = new Question("În imagine este reprezentat numărul: ","6","5","4", 2, "https://ileanadaniela19.000webhostapp.com/numbers/5.jpg", Question.CATEGORY_NUMBERE);
        addQuestion(q13);

        Question q14 = new Question("În imagine este reprezentat numărul: ","24","25","26", 2, "https://ileanadaniela19.000webhostapp.com/numbers/25.jpg" , Question.CATEGORY_NUMBERE);
        addQuestion(q14);

        Question q15 = new Question("În imagine este reprezentat numărul: ","12","13","18", 2, "https://ileanadaniela19.000webhostapp.com/numbers/13.jpg", Question.CATEGORY_NUMBERE);
        addQuestion(q15);

        //ALFABET
        Question q16 = new Question("În imagine este reprezentată litera: ","a","c","d", 2, "https://ileanadaniela19.000webhostapp.com/alphabet/c.png" , Question.CATEGORY_ALFABET);
        addQuestion(q16);

        Question q17 = new Question("În imagine este reprezentată litera: ","b","x","y", 3, "https://ileanadaniela19.000webhostapp.com/alphabet/y.png", Question.CATEGORY_ALFABET);
        addQuestion(q17);

        Question q18 = new Question("În imagine este reprezentată litera: ","t","r","z", 2, "https://ileanadaniela19.000webhostapp.com/alphabet/r.png" , Question.CATEGORY_ALFABET);
        addQuestion(q18);

        Question q19 = new Question("În imagine este reprezentată litera: ","x","c","d", 1, "https://ileanadaniela19.000webhostapp.com/alphabet/x.png" , Question.CATEGORY_ALFABET);
        addQuestion(q19);

        Question q20 = new Question("În imagine este reprezentată litera: ","g","h","p", 1, "https://ileanadaniela19.000webhostapp.com/alphabet/g.png", Question.CATEGORY_ALFABET);
        addQuestion(q20);

        Question q21 = new Question("În imagine este reprezentată litera: ","j","k","l", 2, "https://ileanadaniela19.000webhostapp.com/alphabet/k.png" , Question.CATEGORY_ALFABET);
        addQuestion(q21);

        Question q22 = new Question("În imagine este reprezentată litera: ","f","n","m", 3, "https://ileanadaniela19.000webhostapp.com/alphabet/m.png" , Question.CATEGORY_ALFABET);
        addQuestion(q22);

        Question q23 = new Question("În imagine este reprezentată litera: ","y","c","v", 3, "https://ileanadaniela19.000webhostapp.com/alphabet/v.png" , Question.CATEGORY_ALFABET);
        addQuestion(q23);

        Question q24 = new Question("În imagine este reprezentată litera: ","d","k","t", 1, "https://ileanadaniela19.000webhostapp.com/alphabet/d.png" , Question.CATEGORY_ALFABET);
        addQuestion(q24);

        Question q25 = new Question("În imagine este reprezentată litera: ","z","s","c", 2, "https://ileanadaniela19.000webhostapp.com/alphabet/s.png" , Question.CATEGORY_ALFABET);
        addQuestion(q25);

        Question q26 = new Question("În imagine este reprezentată litera: ","î","ș","ț", 3, "https://ileanadaniela19.000webhostapp.com/alphabet/ț.png", Question.CATEGORY_ALFABET);
        addQuestion(q26);

        Question q27 = new Question("În imagine este reprezentată litera: ","ș","s","â", 1, "https://ileanadaniela19.000webhostapp.com/alphabet/ș.png" , Question.CATEGORY_ALFABET);
        addQuestion(q27);

        Question q28 = new Question("În imagine este reprezentată litera: ","i","î","j", 2, "https://ileanadaniela19.000webhostapp.com/alphabet/î.png" , Question.CATEGORY_ALFABET);
        addQuestion(q28);

        Question q29 = new Question("În imagine este reprezentată litera: ","o","q","d", 1, "https://ileanadaniela19.000webhostapp.com/alphabet/o.png", Question.CATEGORY_ALFABET);
        addQuestion(q29);

        Question q30 = new Question("În imagine este reprezentată litera: ","y","v","w", 3, "https://ileanadaniela19.000webhostapp.com/alphabet/w.png", Question.CATEGORY_ALFABET);
        addQuestion(q30);

        //LEGUME

        Question q31 = new Question("În gif-ul următor este reprezentată leguma: ","morcov","ceapa","ardei", 3, "https://ileanadaniela19.000webhostapp.com/Legume/ardei.gif" , Question.CATEGORY_LEGUME);
        addQuestion(q31);

        Question q32 = new Question("În gif-ul următor este reprezentată leguma: ","morcov","cartof","vinete", 2, "https://ileanadaniela19.000webhostapp.com/Legume/cartof.gif", Question.CATEGORY_LEGUME);
        addQuestion(q32);

        Question q33 = new Question("În gif-ul următor este reprezentată leguma: ","castravete","ardei","ceapa", 1, "https://ileanadaniela19.000webhostapp.com/Legume/castravete.gif", Question.CATEGORY_LEGUME);
        addQuestion(q33);

        Question q34 = new Question("În gif-ul următor este reprezentată leguma: ","ciuperca","ceapa","porumb", 2, "https://ileanadaniela19.000webhostapp.com/Legume/ceapa.gif", Question.CATEGORY_LEGUME);
        addQuestion(q34);

        Question q35 = new Question("În gif-ul următor este reprezentată leguma: ","rosie","cartof","ciuperca", 3, "https://ileanadaniela19.000webhostapp.com/Legume/ciuperca.gif" , Question.CATEGORY_LEGUME);
        addQuestion(q35);

        Question q36 = new Question("În gif-ul următor este reprezentată leguma: ","salata","usturoi","dovlecel", 3, "https://ileanadaniela19.000webhostapp.com/Legume/dovlecel.gif", Question.CATEGORY_LEGUME);
        addQuestion(q36);

        Question q37 = new Question("În gif-ul următor este reprezentată leguma: ","fasole","mazare","spanac", 1, "https://ileanadaniela19.000webhostapp.com/Legume/fasole.gif", Question.CATEGORY_LEGUME);
        addQuestion(q37);

        Question q38 = new Question("În gif-ul următor este reprezentată leguma: ","salata","morcov","conopida", 2, "https://ileanadaniela19.000webhostapp.com/Legume/morcov.gif", Question.CATEGORY_LEGUME);
        addQuestion(q38);

        Question q39 = new Question("În gif-ul următor este reprezentată leguma: ","porumb","ceapa","rosie", 1, "https://ileanadaniela19.000webhostapp.com/Legume/porumb.gif" , Question.CATEGORY_LEGUME);
        addQuestion(q39);

        Question q40 = new Question("În gif-ul următor este reprezentată leguma: ","ciuperca","ridichie","dovlecel", 2, "https://ileanadaniela19.000webhostapp.com/Legume/ridichie.gif" , Question.CATEGORY_LEGUME);
        addQuestion(q40);

        Question q41 = new Question("În gif-ul următor este reprezentată leguma: ","ardei","ridichie","rosie", 3, "https://ileanadaniela19.000webhostapp.com/Legume/rosie.gif" , Question.CATEGORY_LEGUME);
        addQuestion(q41);

        Question q42 = new Question("În gif-ul următor este reprezentată leguma: ","salata","castravete","mazare", 1, "https://ileanadaniela19.000webhostapp.com/Legume/salata.gif", Question.CATEGORY_LEGUME);
        addQuestion(q42);

        Question q43 = new Question("În gif-ul următor este reprezentată leguma: ","ceapa","usturoi","conopida", 2, "https://ileanadaniela19.000webhostapp.com/Legume/usturoi.gif", Question.CATEGORY_LEGUME);
        addQuestion(q43);

        Question q44 = new Question("În gif-ul următor este reprezentată leguma: ","salata","varza","ceapa", 2, "https://ileanadaniela19.000webhostapp.com/Legume/varza.gif" ,Question.CATEGORY_LEGUME);
        addQuestion(q44);

        Question q45 = new Question("În gif-ul următor este reprezentată leguma: ","castravete","varza","vinete", 3, "https://ileanadaniela19.000webhostapp.com/Legume/vinete.gif", Question.CATEGORY_LEGUME);
        addQuestion(q45);

        //FRUCTE
        Question q46 = new Question("În gif-ul următor este reprezentat fructul: ","mar","para","strugure", 1, "https://ileanadaniela19.000webhostapp.com/Legume/mar.gif" , Question.CATEGORY_FRUCTE);
        addQuestion(q46);

        Question q49 = new Question("În gif-ul următor este reprezentat fructul: ","mar","para","strugure", 1, "https://ileanadaniela19.000webhostapp.com/Legume/banana.gif" , Question.CATEGORY_FRUCTE);
        addQuestion(q49);

        Question q50 = new Question("În gif-ul următor este reprezentat fructul: ","zmeura","nuca","capsuni", 3, "https://ileanadaniela19.000webhostapp.com/Legume/capsuni.gif", Question.CATEGORY_FRUCTE);
        addQuestion(q50);

        Question q51 = new Question("În gif-ul următor este reprezentat fructul:","lamaie","caisa","portocala", 2, "https://ileanadaniela19.000webhostapp.com/Legume/caisa.gif", Question.CATEGORY_FRUCTE);
        addQuestion(q51);

        Question q52 = new Question("În gif-ul următor este reprezentat fructul: ","cirese","para","prune", 1, "https://ileanadaniela19.000webhostapp.com/Legume/cirese.gif", Question.CATEGORY_FRUCTE);
        addQuestion(q52);

        Question q53 = new Question("În gif-ul următor este reprezentat fructul: ","strugure","piersica","grapefruit", 3, "https://ileanadaniela19.000webhostapp.com/Legume/grapefruit.gif", Question.CATEGORY_FRUCTE);
        addQuestion(q53);

        Question q54 = new Question("În gif-ul următor este reprezentat fructul:","nuca","lamaie","strugure", 2, "https://ileanadaniela19.000webhostapp.com/Legume/lamaie.gif", Question.CATEGORY_FRUCTE);
        addQuestion(q54);

        Question q55 = new Question("În gif-ul următor este reprezentat fructul: ","mar","nuca","banana", 2, "https://ileanadaniela19.000webhostapp.com/Legume/nuca.gif" , Question.CATEGORY_FRUCTE);
        addQuestion(q55);

        Question q56 = new Question("În gif-ul următor este reprezentat fructul: ","piersica","para","pruna", 1, "https://ileanadaniela19.000webhostapp.com/Legume/piersica.gif", Question.CATEGORY_FRUCTE);
        addQuestion(q56);

        Question q57 = new Question("În gif-ul următor este reprezentat fructul: ","pruna","mandarina","portocala", 3, "https://ileanadaniela19.000webhostapp.com/Legume/portocala.gif", Question.CATEGORY_FRUCTE);
        addQuestion(q57);

        Question q58 = new Question("În gif-ul următor este reprezentat fructul: ","piersica","para","prune", 3, "https://ileanadaniela19.000webhostapp.com/Legume/prune.gif", Question.CATEGORY_FRUCTE);
        addQuestion(q58);

        Question q59 = new Question("În gif-ul următor este reprezentat fructul: ","kiwi","zmeura","strugure", 3, "https://ileanadaniela19.000webhostapp.com/Legume/struguri.gif", Question.CATEGORY_FRUCTE);
        addQuestion(q59);

        Question q60 = new Question("În gif-ul următor este reprezentat fructul: ","zmeura","afine","mango", 1, "https://ileanadaniela19.000webhostapp.com/Legume/zmeura.gif", Question.CATEGORY_FRUCTE);
        addQuestion(q60);

        //ORAȘE
        Question q61= new Question("În gif-ul urmator este reprezentat orasul: ","Alba Iuia","Suceava","Zalau", 1, " https://ileanadaniela19.000webhostapp.com/Orase/Alba-Iulia.gif ", Question.CATEGORY_ORASE);
        addQuestion(q61);

        Question q62= new Question("În gif-ul urmator este reprezentat orasul: ","Bârlad","Bacău","Miercurea Ciuc", 2, " https://ileanadaniela19.000webhostapp.com/Orase/Bacău.gif ", Question.CATEGORY_ORASE);
        addQuestion(q62);

        Question q63= new Question("În gif-ul urmator este reprezentat orasul: ","Baia Mare","Brașov","Sibiu", 1, " https://ileanadaniela19.000webhostapp.com/Orase/Baia Mare.gif ", Question.CATEGORY_ORASE);
        addQuestion(q63);

        Question q64= new Question("În gif-ul urmator este reprezentat orasul: ","Suceava","Bistrița","Craiova", 2, " https://ileanadaniela19.000webhostapp.com/Orase/Bistrița.gif ", Question.CATEGORY_ORASE);
        addQuestion(q64);

        Question q65= new Question("În gif-ul urmator este reprezentat orasul: ","București","Iași","Bacău", 1, " https://ileanadaniela19.000webhostapp.com/Orase/București.gif ", Question.CATEGORY_ORASE);
        addQuestion(q65);

        Question q66= new Question("În gif-ul urmator este reprezentat orasul: ","Bistrița","Buzău","Bacău", 2, " https://ileanadaniela19.000webhostapp.com/Orase/Buzău.gif ", Question.CATEGORY_ORASE);
        addQuestion(q66);

        Question q67= new Question("În gif-ul urmator este reprezentat orasul: ","Satu Mare","Suceava","Slatina", 3, " https://ileanadaniela19.000webhostapp.com/Orase/Slatina.gif ", Question.CATEGORY_ORASE);
        addQuestion(q67);

        Question q68= new Question("În gif-ul urmator este reprezentat orasul: ","Timișoara","Constanța","Suceava", 3, " https://ileanadaniela19.000webhostapp.com/Orase/Suceava.gif ", Question.CATEGORY_ORASE);
        addQuestion(q68);

        Question q69= new Question("În gif-ul urmator este reprezentat orasul: ","Ploiești","Pitești","Alexandria", 1, " https://ileanadaniela19.000webhostapp.com/Orase/Ploiesti.gif ", Question.CATEGORY_ORASE);
        addQuestion(q69);

        Question q70= new Question("În gif-ul urmator este reprezentat orasul: ","Reșița","Arad","Cluj Napoca", 1, " https://ileanadaniela19.000webhostapp.com/Orase/Reșita.gif ", Question.CATEGORY_ORASE);
        addQuestion(q70);

        Question q71= new Question("În gif-ul urmator este reprezentat orasul: ","Buzău","Giurgiu","Focșani", 2, " https://ileanadaniela19.000webhostapp.com/Orase/Giurgiu.gif ", Question.CATEGORY_ORASE);
        addQuestion(q71);

        Question q72= new Question("În gif-ul urmator este reprezentat orasul: ","Cluj Napoca","Suceava","Slobozia", 1, " https://ileanadaniela19.000webhostapp.com/Orase/Cluj Napoca.gif ", Question.CATEGORY_ORASE);
        addQuestion(q72);

        Question q73= new Question("În gif-ul urmator este reprezentat orasul: ","Iași","Deva","Sibiu", 2, " https://ileanadaniela19.000webhostapp.com/Orase/Deva.gif", Question.CATEGORY_ORASE);
        addQuestion(q73);

        Question q74= new Question("În gif-ul urmator este reprezentat orasul: ","Tulcea","Suceava","Oradea", 3, " https://ileanadaniela19.000webhostapp.com/Orase/Oradea.gif", Question.CATEGORY_ORASE);
        addQuestion(q74);

        Question q75= new Question("În gif-ul urmator este reprezentat orasul: ","Satu Mare","Sfântu Gheorghe","Sibiu", 3, " https://ileanadaniela19.000webhostapp.com/Orase/Sibiu.gif", Question.CATEGORY_ORASE);
        addQuestion(q75);

        //LOCURI
        Question q76= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Facultate","Hotel","Liceu", 1, " https://ileanadaniela19.000webhostapp.com/Locuri/Facultate.gif", Question.CATEGORY_LOCURI);
        addQuestion(q76);

        Question q77= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Hotel","Acasă","Magazin", 2, " https://ileanadaniela19.000webhostapp.com/Locuri/Acasa.gif", Question.CATEGORY_LOCURI);
        addQuestion(q77);

        Question q78= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Club","Școala","Cascadă", 3, " https://ileanadaniela19.000webhostapp.com/Locuri/Cascada.gif", Question.CATEGORY_LOCURI);
        addQuestion(q78);

        Question q79= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Club","Casă de cultură","Parc", 1, " https://ileanadaniela19.000webhostapp.com/Locuri/Club.gif", Question.CATEGORY_LOCURI);
        addQuestion(q79);

        Question q80= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Hotel","Mare","Primarie", 1, " https://ileanadaniela19.000webhostapp.com/Locuri/Hotel.gif", Question.CATEGORY_LOCURI);
        addQuestion(q80);

        Question q81= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Magazin","Muzeu","Liceu", 2, " https://ileanadaniela19.000webhostapp.com/Locuri/Muzeu.gif", Question.CATEGORY_LOCURI);
        addQuestion(q81);

        Question q82= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Mănăstire","Casă","Munte", 3, " https://ileanadaniela19.000webhostapp.com/Locuri/Munte.gif", Question.CATEGORY_LOCURI);
        addQuestion(q82);

        Question q83= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Primărie","Parc","Piața", 3," https://ileanadaniela19.000webhostapp.com/Locuri/Piață.gif", Question.CATEGORY_LOCURI);
        addQuestion(q83);

        Question q84= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Parc","Pădure","Spital", 1, " https://ileanadaniela19.000webhostapp.com/Locuri/Parc.gif", Question.CATEGORY_LOCURI);
        addQuestion(q84);

        Question q85= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Hotel","Restaurant","Club", 2, " https://ileanadaniela19.000webhostapp.com/Locuri/Restaurant.gif", Question.CATEGORY_LOCURI);
        addQuestion(q85);

        Question q86= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Liceu","Spital","Mare", 2, " https://ileanadaniela19.000webhostapp.com/Locuri/Spital.gif", Question.CATEGORY_LOCURI);
        addQuestion(q86);

        Question q87= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Facultate","Liceu","Școala", 3, " https://ileanadaniela19.000webhostapp.com/Locuri/Școala.gif", Question.CATEGORY_LOCURI);
        addQuestion(q87);

        Question q88= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Muzeu","Grădiniță","Magazin", 3, " https://ileanadaniela19.000webhostapp.com/Locuri/Magazin.gif", Question.CATEGORY_LOCURI);
        addQuestion(q88);

        Question q89= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Mănăstire","Munte","Magazin", 1, " https://ileanadaniela19.000webhostapp.com/Locuri/Mănăstire.gif", Question.CATEGORY_LOCURI);
        addQuestion(q89);

        Question q90= new Question("În gif-ul urmator este reprezentat urmatorul loc: ","Facultate","Farmacie","Acasă", 2, " https://ileanadaniela19.000webhostapp.com/Locuri/Farmacie.gif", Question.CATEGORY_LOCURI);
        addQuestion(q90);

        //MANCARE

        Question q91= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Cașcaval","Maioneza","Piure", 3, "https://ileanadaniela19.000webhostapp.com/Mancare/Piure.gif", Question.CATEGORY_MANCARE);
        addQuestion(q91);

        Question q92= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Mămăligă","Supă","Cârnați", 2, "https://ileanadaniela19.000webhostapp.com/Mancare/Supă.gif", Question.CATEGORY_MANCARE);
        addQuestion(q92);


        Question q93= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Supă cremă","Maioneza","Pizza", 1, "https://ileanadaniela19.000webhostapp.com/Mancare/Supă cremă.gif", Question.CATEGORY_MANCARE);
        addQuestion(q93);


        Question q94= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Tăiței","Telemea","Carne", 1, "https://ileanadaniela19.000webhostapp.com/Mancare/Tăiței.gif", Question.CATEGORY_MANCARE);
        addQuestion(q94);

        Question q95= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Supă","Prăjitură","Înghețată", 3, "https://ileanadaniela19.000webhostapp.com/Mancare/Înghețată.gif", Question.CATEGORY_MANCARE);
        addQuestion(q95);

        Question q96= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Cașcaval","Carne","Cârnați", 3, "https://ileanadaniela19.000webhostapp.com/Mancare/Cârnați.gif", Question.CATEGORY_MANCARE);
        addQuestion(q96);

        Question q97= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Telemea","Cartofi prăjiți","Pizza", 2, "https://ileanadaniela19.000webhostapp.com/Mancare/Cartofi prăjiți.gif", Question.CATEGORY_MANCARE);
        addQuestion(q97);

        Question q98= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Brânza","Carne","Piure", 2, "https://ileanadaniela19.000webhostapp.com/Mancare/Carne.gif", Question.CATEGORY_MANCARE);
        addQuestion(q98);

        Question q99= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Mămăligă","Prăjitură","Înghețată", 2, "https://ileanadaniela19.000webhostapp.com/Mancare/Prăjitură.gif", Question.CATEGORY_MANCARE);
        addQuestion(q99);

        Question q100= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Pizza","Paste","Piure", 1, "https://ileanadaniela19.000webhostapp.com/Mancare/Pizza.gif", Question.CATEGORY_MANCARE);
        addQuestion(q100);

        Question q101= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Cârnați","Brânza","Mămăligă", 3, "https://ileanadaniela19.000webhostapp.com/Mancare/Mămăligă.gif", Question.CATEGORY_MANCARE);
        addQuestion(q101);

        Question q102= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Telemea","Prajitură","Supă", 1, "https://ileanadaniela19.000webhostapp.com/Mancare/Telemea.gif", Question.CATEGORY_MANCARE);
        addQuestion(q102);

        Question q103= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Desert","Ciorbă","Aluat", 1, "https://ileanadaniela19.000webhostapp.com/Mancare/Desert.gif", Question.CATEGORY_MANCARE);
        addQuestion(q103);

        Question q104= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Cârnați","Cașcaval","Pizza", 2, "https://ileanadaniela19.000webhostapp.com/Mancare/Cașcaval.gif", Question.CATEGORY_MANCARE);
        addQuestion(q104);

        Question q105= new Question("În gif-ul urmator este reprezentată urmatoarea mancare: ","Ciocolată","Maioneza","Bomboane", 3, "https://ileanadaniela19.000webhostapp.com/Mancare/Bomboane.gif", Question.CATEGORY_MANCARE);
        addQuestion(q105);

        //BAUTURI
        Question q106= new Question("În gif-ul urmator este reprezentată urmatoarea băutura: ","Cafea","Bere","Gin", 2, "https://ileanadaniela19.000webhostapp.com/Bauturi/Bere.gif", Question.CATEGORY_BAUTURA);
        addQuestion(q106);

        Question q107= new Question("În gif-ul urmator este reprezentată urmatoarea băutura: ","Sirop","Vin","Cafea", 3, "https://ileanadaniela19.000webhostapp.com/Bauturi/Cafea.gif", Question.CATEGORY_BAUTURA);
        addQuestion(q107);

        Question q108= new Question("În gif-ul urmator este reprezentată urmatoarea băutura: ","Suc","Sirop","Cappucino", 1, "https://ileanadaniela19.000webhostapp.com/Bauturi/Suc.gif", Question.CATEGORY_BAUTURA);
        addQuestion(q108);

        Question q109= new Question("În gif-ul urmator este reprezentată urmatoarea băutura: ","Vin","Bere","Sirop", 1, "https://ileanadaniela19.000webhostapp.com/Bauturi/Vin.gif", Question.CATEGORY_BAUTURA);
        addQuestion(q109);

        Question q110= new Question("În gif-ul urmator este reprezentată urmatoarea băutura: ","Bere","Gin","Sirop", 3, "https://ileanadaniela19.000webhostapp.com/Bauturi/Sirop.gif", Question.CATEGORY_BAUTURA);
        addQuestion(q110);

        //FAMILIE
        Question q111= new Question("În gif-ul urmator este reprezentat urmatoarul membru al familiei: ","Soacră","Ginere","Unchi", 3, " https://ileanadaniela19.000webhostapp.com/Familie/unchi.gif", Question.CATEGORY_FAMILIE);
        addQuestion(q111);

        Question q112= new Question("În gif-ul urmator este reprezentat urmatoarul membru al familiei: ","Soacră","Unchi","Mătușă", 3, " https://ileanadaniela19.000webhostapp.com/Familie/matusa.gif", Question.CATEGORY_FAMILIE);
        addQuestion(q112);

        Question q113= new Question("În gif-ul urmator este reprezentat urmatoarul membru al familiei: ","Bunică","Frate","Soră", 2, " https://ileanadaniela19.000webhostapp.com/Familie/frate.gif", Question.CATEGORY_FAMILIE);
        addQuestion(q113);

        Question q114= new Question("În gif-ul urmator este reprezentat urmatoarul membru al familiei: ","Soră","Frate","Soacră", 1, " https://ileanadaniela19.000webhostapp.com/Familie/sora.gif", Question.CATEGORY_FAMILIE);
        addQuestion(q114);

        Question q115= new Question("În gif-ul urmator este reprezentat urmatoarul membru al familiei: ","Soacră","Nepot","Nepoată", 2, " https://ileanadaniela19.000webhostapp.com/Familie/nepot.gif", Question.CATEGORY_FAMILIE);
        addQuestion(q115);

        Question q116= new Question("În gif-ul urmator este reprezentat urmatoarul membru al familiei: ","Tată","Mamă","Bunică", 2, " https://ileanadaniela19.000webhostapp.com/Familie/mama.gif", Question.CATEGORY_FAMILIE);
        addQuestion(q116);

        Question q117= new Question("În gif-ul urmator este reprezentat urmatoarul membru al familiei: ","Bunic","Bunică","Unchi", 1, " https://ileanadaniela19.000webhostapp.com/Familie/bunic.gif", Question.CATEGORY_FAMILIE);
        addQuestion(q117);

        Question q118= new Question("În gif-ul urmator este reprezentat urmatoarul membru al familiei: ","Soră","Fiică","Copil", 3, " https://ileanadaniela19.000webhostapp.com/Familie/copil.gif", Question.CATEGORY_FAMILIE);
        addQuestion(q118);

        Question q119= new Question("În gif-ul urmator este reprezentat urmatoarul membru al familiei: ","Soție","Ginere","Mătușă", 1, " https://ileanadaniela19.000webhostapp.com/Familie/sotie.gif", Question.CATEGORY_FAMILIE);
        addQuestion(q119);

        Question q120= new Question("În gif-ul urmator este reprezentat urmatoarul membru al familiei: ","Tată","Mamă","Bunică", 1, " https://ileanadaniela19.000webhostapp.com/Familie/tata.gif", Question.CATEGORY_FAMILIE);
        addQuestion(q120);

        //ANIMALE
        Question q121= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Cal","Găină","Urs", 1, " https://ileanadaniela19.000webhostapp.com/Animale/Cal.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q121);

        Question q122= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Arici","Cal","Vacă", 1, " https://ileanadaniela19.000webhostapp.com/Animale/Arici.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q122);

        Question q123= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Vulpe","Broască","Mânz", 2, " https://ileanadaniela19.000webhostapp.com/Animale/Broască.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q123);

        Question q124= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Urs","Bivol","Bou", 3, " https://ileanadaniela19.000webhostapp.com/Animale/Bou.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q124);

        Question q125= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Găină","Focă","Gâscă", 2, " https://ileanadaniela19.000webhostapp.com/Animale/Focă.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q125);

        Question q126= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Girafă","Crab","Măgar", 2, " https://ileanadaniela19.000webhostapp.com/Animale/Crab.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q126);

        Question q127= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Iepure","Dinozaur","Delfin", 3, " https://ileanadaniela19.000webhostapp.com/Animale/Delfin.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q127);

        Question q128= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Găină","Liliac","Girafă", 3, " https://ileanadaniela19.000webhostapp.com/Animale/Girafă.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q128);

        Question q129= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Elefant","Urs","Măgar", 1, " https://ileanadaniela19.000webhostapp.com/Animale/Elefant.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q129);

        Question q130= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Zimbru","Lebădă","Struț", 2, " https://ileanadaniela19.000webhostapp.com/Animale/Lebădă.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q130);

        Question q131= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Delfin","Hipopotam","Măgar", 2, " https://ileanadaniela19.000webhostapp.com/Animale/Hipopotam.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q131);

        Question q132= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Iepure","Ied","Viezure", 1, " https://ileanadaniela19.000webhostapp.com/Animale/Iepure.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q132);

        Question q133= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Căprioară","Mistreț","Lup", 3, " https://ileanadaniela19.000webhostapp.com/Animale/Lup.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q133);

        Question q134= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Liliac","Mânz","Cangur", 1, " https://ileanadaniela19.000webhostapp.com/Animale/Liliac.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q134);

        Question q135= new Question("În gif-ul urmator este reprezentat urmatoarul animal: ","Vacă","Vultur","Vulpe", 2, " https://ileanadaniela19.000webhostapp.com/Animale/Vultur.gif", Question.CATEGORY_ANIMALE);
        addQuestion(q135);

        //Emotii
        Question q136= new Question("În gif-ul urmator este reprezentată urmatoarea emoție: ","Anxietate","Trist","Suparat", 2, " https://ileanadaniela19.000webhostapp.com/Emotii/Trist.gif", Question.CATEGORY_EMOTII);
        addQuestion(q136);

        Question q137= new Question("În gif-ul urmator este reprezentată urmatoarea emoție: ","Frică","Rușine","Surpriza", 3, " https://ileanadaniela19.000webhostapp.com/Emotii/Surpriză.gif", Question.CATEGORY_EMOTII);
        addQuestion(q137);

        Question q138= new Question("În gif-ul urmator este reprezentată urmatoarea emoție: ","Supărat","Trist","Dezamăgit", 1, " https://ileanadaniela19.000webhostapp.com/Emotii/Supărat.gif", Question.CATEGORY_EMOTII);
        addQuestion(q138);

        Question q139= new Question("În gif-ul urmator este reprezentată urmatoarea emoție: ","Binecuvântare","Anxietate","Rușine", 3, " https://ileanadaniela19.000webhostapp.com/Emotii/Rușine.gif", Question.CATEGORY_EMOTII);
        addQuestion(q139);

        Question q140= new Question("În gif-ul urmator este reprezentată urmatoarea emoție: ","Fericire","Supărat","Frică", 3, " https://ileanadaniela19.000webhostapp.com/Emotii/Frică.gif", Question.CATEGORY_EMOTII);
        addQuestion(q140);

        Question q141= new Question("În gif-ul urmator este reprezentată urmatoarea emoție: ","Dezamăgit","Fericire","Trist", 2, " https://ileanadaniela19.000webhostapp.com/Emotii/Fericire.gif", Question.CATEGORY_EMOTII);
        addQuestion(q141);

        Question q142= new Question("În gif-ul urmator este reprezentată urmatoarea emoție: ","Surpriză","Dragoste","Anxietate", 2, " https://ileanadaniela19.000webhostapp.com/Emotii/Dragoste.gif", Question.CATEGORY_EMOTII);
        addQuestion(q142);

        Question q143= new Question("În gif-ul urmator este reprezentată urmatoarea emoție: ","Dezamăgit","Trist","Dragoste", 1, " https://ileanadaniela19.000webhostapp.com/Emotii/Dezamăgit.gif", Question.CATEGORY_EMOTII);
        addQuestion(q143);

        Question q144= new Question("În gif-ul urmator este reprezentată urmatoarea emoție: ","Binecuvântare","Dezamăgit","Rușine", 1, " https://ileanadaniela19.000webhostapp.com/Emotii/Binecuvântare.gif", Question.CATEGORY_EMOTII);
        addQuestion(q144);

        Question q145= new Question("În gif-ul urmator este reprezentată urmatoarea emoție: ","Frică","Anxietate","Fericire", 2, " https://ileanadaniela19.000webhostapp.com/Emotii/Anxietate.gif", Question.CATEGORY_EMOTII);
        addQuestion(q145);


    }
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuizContract.QuestionsTable.COLUMN_ULRIMAGE,question.getUrlImage());
        cv.put(QuizContract.QuestionsTable.COLUMN_CATEGORY, question.getCategory());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                question.setUrlImage(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ULRIMAGE)));
                question.setCategory(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CATEGORY)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestionsByCategory(String category) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String sql="SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME +
                " WHERE " + QuizContract.QuestionsTable.COLUMN_CATEGORY + " = '"+category +"'";
        String[] selectionArgs = new String[]{category};
        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                question.setUrlImage(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ULRIMAGE)));
                question.setCategory(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CATEGORY)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
