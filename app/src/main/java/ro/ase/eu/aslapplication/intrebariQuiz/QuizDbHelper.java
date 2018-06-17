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

    private static final String DATABASE_NAME = "DatabaseQuiz5.db";
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
        final String SQL_QUESTION2_TABLE="CREATE TABLE "+
                QuizContract.Questions2Table.TABLE_NAME2+ " ( "+
                QuizContract.Questions2Table._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.Questions2Table.COLUMN_QUESTION + " TEXT, " +
                QuizContract.Questions2Table.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.Questions2Table.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.Questions2Table.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.Questions2Table.COLUMN_OPTION4 + " TEXT, " +
                QuizContract.Questions2Table.COLUMN_ANSWER_NR + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_TABLE);
        db.execSQL(SQL_QUESTION2_TABLE);
        //fill table
        fillQuestionsTable();
        fillQuestionTable2();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ QuizContract.Questions2Table.TABLE_NAME2);
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

        //Expresii
        Question q146= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Acesta este soțul meu","Acesta este colegul meu","Aveți dreptate", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/acesta%20este%20colegul%20meu.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q146);

        Question q147= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Aveți vreo legitimație la dvs","Am să vă fac cunoștință","Aș dori să-ți cer sfatul", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/am%20s%C4%83%20v%C4%83%20fac%20cuno%C8%99tin%C8%9B%C4%83.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q147);

        Question q148= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Aș vrea să știu unde pot cumpara","Ați putea să semnați aici vă rog","Ați putea vorbi mai rar și clar vă rog", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/a%C8%9Bi%20putea%20vorbi%20mai%20rar%20%C8%99i%20clar%20v%C4%83%20rog.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q148);

        Question q149= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Care este problema","Care este starea dvs civilă","Casă de piatră", 1, "https://teratoid-photodiode.000webhostapp.com/Translate/care%20este%20problema.gif", Question.CATEGORY_EXPRESII);
        addQuestion(q149);

        Question q150= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Ce s-a întâmplat","Ce doriți","Ce este acolo", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/ce%20dori%C8%9Bi.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q150);


        Question q151= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Ce vârstă ai","Ce doriți","Ce mai faci", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/ce%20mai%20faci.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q151);

        Question q152= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Cred ca da ","Cine este acolo","Ce este acolo", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/cine%20este%20acolo.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q152);

        Question q153= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Cred că ne-am mai întâlnit ","Cum se numește","Cred că da", 1, " https://teratoid-photodiode.000webhostapp.com/Translate/cred%20c%C4%83%20ne-am%20mai%20%C3%AEnt%C3%A2lnit.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q153);

        Question q154= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Da sunt absolut sigur","De unde sunteți","De unde veniți", 1, " https://teratoid-photodiode.000webhostapp.com/Translate/da%20sunt%20absolut%20sigur.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q154);


        Question q155= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","E o idee bună ","Este foarte important","Este posibil", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/este%20foarte%20important.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q155);

        Question q156= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Fii liniștit ","Felicitări","Foarte bine", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/foarte%20bine.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q156);

        Question q157= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","De unde veniți","La revedere","Intrați vă rog", 3, "https://teratoid-photodiode.000webhostapp.com/Translate/intra%C8%9Bi%20v%C4%83%20rog.gif", Question.CATEGORY_EXPRESII);
        addQuestion(q157);

        Question q158= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Mulțumesc bine","Mă simt foarte descurajat","Mi-a plăcut foarte mult aici", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/mi-a%20pl%C4%83cut%20foarte%20mult%20aici.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q158);

        Question q159= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Ne vedem mai târziu","Ne înțelegem perfect","Nu am găsit", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/ne%20%C3%AEn%C8%9Belegem%20perfect.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q159);

        Question q160= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Nu contează ","Nu pot să accept asta","Nu te supara", 1, " https://teratoid-photodiode.000webhostapp.com/Translate/nu%20conteaz%C4%83.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q160);

        Question q161= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Nu mă interesează ","Nu pot veni mâine","Nu sunt de-acord cu tine", 1, " https://teratoid-photodiode.000webhostapp.com/Translate/nu%20m%C4%83%20intereseaz%C4%83.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q161);

        Question q162= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Poftim ","Pot să vă cer o informație","Pot intra", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/pot%20s%C4%83%20v%C4%83%20cer%20o%20informa%C8%9Bie.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q162);

        Question q163= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Sunt foarte bucuros de asta ","Sunt de-acord cu tine","Sper să ne vedem curând", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/sper%20s%C4%83%20ne%20vedem%20%C3%AEn%20curand.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q163);

        Question q164= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Trebuie să refuz ","Trebuie să ne mai întâlnim","Unde este", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/trebuie%20s%C4%83%20ne%20mai%20%C3%AEnt%C3%A2lnim.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q164);

        Question q165= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Vreți să mă ajutați ","Vă place aici","Vă rog", 1, " https://teratoid-photodiode.000webhostapp.com/Translate/vre%C8%9Bi%20s%C4%83%20m%C4%83%20ajuta%C8%9Bi.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q165);

        Question q166= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Ați putea repeta vă rog","Aceasta este prietena mea","Vă rog", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/aceasta%20este%20prietena%20mea.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q166);

        Question q167= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Așa este ","Am o rugăminte","Am să plec", 2, "https://teratoid-photodiode.000webhostapp.com/Translate/am%20o%20rug%C4%83minte.gif", Question.CATEGORY_EXPRESII);
        addQuestion(q167);

        Question q168= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Aveți dreptate ","Vă place aici","Aș vrea să știu unde pot cumpăra", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/a%C8%99%20vrea%20s%C4%83%20%C8%99tiu%20unde%20pot%20cumpara.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q168);


        Question q169= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Ce număr de telefon aveți ","Ce faceți aici","Ce mai faci", 1, " https://teratoid-photodiode.000webhostapp.com/Translate/ce%20num%C4%83r%20de%20telefon%20ave%C8%9Bi.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q169);

        Question q170= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Cine mă caută ","Cineva a fost aici","Cine a spus asta", 1, " https://teratoid-photodiode.000webhostapp.com/Translate/cine%20m%C4%83%20caut%C4%83.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q170);

        Question q171= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Ce pot face pentru dvs ","Ce s-a întâmplat","Ce vârstă aveți", 1, " https://teratoid-photodiode.000webhostapp.com/Translate/ce%20pot%20face%20pentru%20dvs.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q171);

        Question q172= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Cred că da ","Cine este acolo","Cum ajung la", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/cum%20ajung%20la.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q172);

        Question q173= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Cum este vremea ","Cu plăcere","Cum te simți", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/cum%20te%20sim%C8%9Bi.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q173);

        Question q174= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Câți ani are el și ea","Când se deschide","Când plecați", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/c%C3%A2nd%20se%20deschide.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q174);

        Question q175= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Câți ani are el și ea ","Câți sunteți in clasă","Cât este ceasul", 1, "https://teratoid-photodiode.000webhostapp.com/Translate/c%C3%A2%C8%9Bi%20ani%20are%20el%20%C8%99i%20ea.gif", Question.CATEGORY_EXPRESII);
        addQuestion(q175);


        Question q176= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Despre ce e vorba","Dați-mi voie să mă prezint","De la cine este", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/da%C8%9Bi-mi%20voie%20s%C4%83%20m%C4%83%20prezint.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q176);

        Question q177= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","E adevărat","E deja târziu","Este posibil să fie acolo", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/e%20deja%20t%C3%A2rziu.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q177);

        Question q178= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","La mulți ani ","Luați și dvs","Locul acesta este ocupat", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/locul%20acesta%20este%20ocupat.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q178);

        Question q179= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Ne simțim bine ","Ne place foarte mult aici","Este foarte important", 1, "https://teratoid-photodiode.000webhostapp.com/Translate/ne%20sim%C8%9Bim%20bine.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q179);

        Question q180= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Nu cred că are sens","Nu vă faceți griji","Nu prea bine", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/nu%20prea%20bine.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q180);

        Question q181= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Vreți să mă ajutați ","Pe aici vă rog","Este și el acolo", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/pe%20aici%20v%C4%83%20rog.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q181);

        Question q182= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Scuzați-mă sunteți domnul ","Se mai întâmplă","Sund de-acord cu tine", 1, " https://teratoid-photodiode.000webhostapp.com/Translate/Scuza%C8%9Bi-m%C4%83%20sunte%C8%9Bi%20domnul.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q182);

        Question q183= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Unde ați pus cheile","Uite aici","Unde ai fost ieri", 3, " https://teratoid-photodiode.000webhostapp.com/Translate/unde%20ai%20fost%20ieri.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q183);

        Question q184= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Vreți să poftiți inauntru","Vă felicit pentru ce faceți","Vreți să mă ajutați", 1, " https://teratoid-photodiode.000webhostapp.com/Translate/vre%C8%9Bi%20s%C4%83%20pofti%C8%9Bi%20%C3%AEnauntru.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q184);

        Question q185= new Question("În gif-ul urmator este reprezentată urmatoarea expresie: ","Îmi merge bine","Îți doresc mult success în activitate","În ce data suntem azi", 2, " https://teratoid-photodiode.000webhostapp.com/Translate/%C3%AE%C8%9Bi%20doresc%20mult%20succes%20%C3%AEn%20activitate.gif ", Question.CATEGORY_EXPRESII);
        addQuestion(q185);

    }

    private void fillQuestionTable2(){
        Question2 q1= new Question2("În ce imagine este reprezentat cuvântul CULOARE : ","https://ileanadaniela19.000webhostapp.com/Culori/culoare.gif","https://ileanadaniela19.000webhostapp.com/Familie/baiat.gif","https://ileanadaniela19.000webhostapp.com/Emotii/Anxietate.gif","https://ileanadaniela19.000webhostapp.com/Fructe/capsuni.gif",1);
        addQuestion2(q1);

        Question2 q2=new Question2("În ce imagine este reprezentat cuvântul  PORTOCALĂ :","https://ileanadaniela19.000webhostapp.com/Animale/Cangur.gif","https://ileanadaniela19.000webhostapp.com/Animale/Leu.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Bere.gif","https://ileanadaniela19.000webhostapp.com/Fructe/portocala.gif",4);
        addQuestion2(q2);

        Question2 q3=new Question2("În ce imagine este reprezentat cuvântul ROSU : ","https://ileanadaniela19.000webhostapp.com/Legume/ardei.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Bere.gif","https://ileanadaniela19.000webhostapp.com/Culori/rosu.gif","https://ileanadaniela19.000webhostapp.com/Emotii/Anxietate.gif",3);
        addQuestion2(q3);

        Question2 q4=new Question2("În ce imagine este reprezentat cuvântul  FASOLE : ","https://ileanadaniela19.000webhostapp.com/Animale/Focă.gif","https://ileanadaniela19.000webhostapp.com/Legume/fasole.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Ceai.gif","https://ileanadaniela19.000webhostapp.com/Mancare/Desert.gif",2);
        addQuestion2(q4);

        Question2 q5=new Question2("În ce imagine este reprezentat cuvântul PIZZA :","https://ileanadaniela19.000webhostapp.com/Mancare/Pizza.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Cafea.gif","https://ileanadaniela19.000webhostapp.com/Culori/mov.gif","https://ileanadaniela19.000webhostapp.com/Animale/Hipopotam.gif",1);
        addQuestion2(q5);

        Question2 q6=new Question2("În ce imagine este reprezentat cuvântul  CĂMILĂ : ","https://ileanadaniela19.000webhostapp.com/Bauturi/Bere.gif","https://ileanadaniela19.000webhostapp.com/Animale/Leu.gif","https://ileanadaniela19.000webhostapp.com/Animale/Hipopotam.gif","https://ileanadaniela19.000webhostapp.com/Animale/Cămilă.gif",4);
        addQuestion2(q6);

        Question2 q7=new Question2("În ce imagine este reprezentat cuvântul  CAPPUCINO : ","https://ileanadaniela19.000webhostapp.com/Orase/Constanstanța.gif","https://ileanadaniela19.000webhostapp.com/Legume/ceapa.gif","https://ileanadaniela19.000webhostapp.com/Culori/gri.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Cappucino.gif",4);
        addQuestion2(q7);

        Question2 q8=new Question2("În ce imagine este reprezentat cuvântul CAISĂ : ","https://ileanadaniela19.000webhostapp.com/Bauturi/Ceai.gif","https://ileanadaniela19.000webhostapp.com/Emotii/Frică.gif","https://ileanadaniela19.000webhostapp.com/Fructe/caisa.gif","https://ileanadaniela19.000webhostapp.com/Animale/Focă.gif ",3);
        addQuestion2(q8);

        Question2 q9=new Question2("În ce imagine este reprezentat cuvântul BUCUREȘTI : ","https://ileanadaniela19.000webhostapp.com/Orase/București.gif","https://ileanadaniela19.000webhostapp.com/Legume/salata.gif","https://ileanadaniela19.000webhostapp.com/Mancare/Cârnați.gif","https://ileanadaniela19.000webhostapp.com/Familie/matusa.gif",1);
        addQuestion2(q9);

        Question2 q10=new Question2("În ce imagine este reprezentat cuvântul GIURGIU : ","https://ileanadaniela19.000webhostapp.com/Culori/galben.gif","https://ileanadaniela19.000webhostapp.com/Orase/Giurgiu.gif","https://ileanadaniela19.000webhostapp.com/Animale/Girafă.gif","https://ileanadaniela19.000webhostapp.com/Animale/Gâscă.gif",2);
        addQuestion2(q10);

        Question2 q11=new Question2("În ce imagine este reprezentat cuvântul ELEFANT : ","https://ileanadaniela19.000webhostapp.com/Culori/alb.gif","https://ileanadaniela19.000webhostapp.com/Animale/Crocodil.gif","https://ileanadaniela19.000webhostapp.com/Animale/Elefant.gif","https://ileanadaniela19.000webhostapp.com/Legume/legume.gif",3);
        addQuestion2(q11);

        Question2 q12=new Question2("În ce imagine este reprezentat cuvântul VIN(băutura) : ","https://ileanadaniela19.000webhostapp.com/Culori/violet.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Vin.gif","https://ileanadaniela19.000webhostapp.com/Fructe/zmeura.gif","https://ileanadaniela19.000webhostapp.com/Mancare/Înghețată.gif",2);
        addQuestion2(q12);

        Question2 q13=new Question2("În ce imagine este reprezentat cuvântul  VIOLET :","https://ileanadaniela19.000webhostapp.com/Culori/violet.gif","https://ileanadaniela19.000webhostapp.com/Culori/gri.gif","https://ileanadaniela19.000webhostapp.com/Familie/copil.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Cafea.gif",1);
        addQuestion2(q13);

        Question2 q14=new Question2("În ce imagine este reprezentat cuvântul  MAIONEZĂ :","https://ileanadaniela19.000webhostapp.com/Mancare/Maioneză.gif","https://ileanadaniela19.000webhostapp.com/Mancare/Pizza.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Bere.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Vin.gif",1);
        addQuestion2(q14);

        Question2 q15=new Question2("În ce imagine este reprezentat cuvântul  COPIL :","https://ileanadaniela19.000webhostapp.com/Animale/Hipopotam.gif","https://ileanadaniela19.000webhostapp.com/Mancare/Telemea.gif","https://ileanadaniela19.000webhostapp.com/Familie/copil.gif","https://ileanadaniela19.000webhostapp.com/Orase/Craiova.gif",3);
        addQuestion2(q15);

        Question2 q16=new Question2("În ce imagine este reprezentat cuvântul  MAIMUȚĂ :","https://ileanadaniela19.000webhostapp.com/Culori/gri.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Bere.gif","https://ileanadaniela19.000webhostapp.com/Animale/Crocodil.gif","https://ileanadaniela19.000webhostapp.com/Animale/Maimuță.gif",4);
        addQuestion2(q16);

        Question2 q17= new Question2("În ce imagine este reprezentat cuvântul  SIROP :","https://ileanadaniela19.000webhostapp.com/Emotii/Dragoste.gif","https://ileanadaniela19.000webhostapp.com/Bauturi/Sirop.gif","https://ileanadaniela19.000webhostapp.com/Culori/rosu.gif","https://ileanadaniela19.000webhostapp.com/Familie/fiu.gif",2);
        addQuestion2(q17);

        Question2 q18=new Question2("În ce imagine este reprezentat cuvântul  ZEBRĂ :","https://ileanadaniela19.000webhostapp.com/Fructe/mar.gif","https://ileanadaniela19.000webhostapp.com/Familie/bunic.gif","https://ileanadaniela19.000webhostapp.com/Emotii/Surpriză.gif","https://ileanadaniela19.000webhostapp.com/Animale/Zebră.gif",4);
        addQuestion2(q18);

        Question2 q19 =new Question2("În ce imagine este reprezentat cuvântul  SOȚIE :","https://ileanadaniela19.000webhostapp.com/Familie/sotie.gif","https://ileanadaniela19.000webhostapp.com/Familie/sot.gif","https://ileanadaniela19.000webhostapp.com/Legume/salata.gif","https://ileanadaniela19.000webhostapp.com/Animale/Stru%C8%9B.gif",1);
        addQuestion2(q19);

        Question2 q20=new Question2("În ce imagine este reprezentat cuvântul  SLATINA :","https://ileanadaniela19.000webhostapp.com/Orase/Suceava.gif","https://ileanadaniela19.000webhostapp.com/Fructe/piersica.gif","https://ileanadaniela19.000webhostapp.com/Orase/Slatina.gif","https://ileanadaniela19.000webhostapp.com/Animale/Pisică.gif",3);
        addQuestion2(q20);

        Question2 q21=new Question2("În ce imagine este reprezentată expresia Aceasta este prietena mea:"," https://teratoid-photodiode.000webhostapp.com/Translate/aceasta%20este%20prietena%20mea.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/acesta%20este%20colegul%20meu.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/am%20%C3%AEn%C8%9Beles.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/ave%C8%9Bi%20dreptate-1.gif",1);
        addQuestion2(q21);

        Question2 q22=new Question2("În ce imagine este reprezentată expresia Am să vă conduc:"," https://teratoid-photodiode.000webhostapp.com/Translate/a%C8%99%20dori%20s%C4%83-l%20cunosc.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/am%20s%C4%83%20v%C4%83%20conduc.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/a%C8%99a%20este.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/bine%C3%AEnteles.gif",2);
        addQuestion2(q22);


        Question2 q23=new Question2("În ce imagine este reprezentată expresia Ați putea repeta vă rog:"," https://teratoid-photodiode.000webhostapp.com/Translate/a%C8%9Bi%20putea%20s%C4%83%20semna%C8%9Bi%20aici%20va%20rog.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/ave%C8%9Bi%20vreo%20legitima%C8%9Bie%20la%20dvs.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/a%C8%9Bi%20putea%20repeta%20v%C4%83%20rog.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/care%20este%20problema.gif",3);
        addQuestion2(q23);


        Question2 q24=new Question2("În ce imagine este reprezentată expresia Care este problema:"," https://teratoid-photodiode.000webhostapp.com/Translate/bun%C4%83%20seara.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/care%20este%20problema.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/care%20este%20starea%20dvs%20civil%C4%83.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/cas%C4%83%20de%20piatr%C4%83.gif",2);
        addQuestion2(q24);

        Question2 q25=new Question2("În ce imagine este reprezentată expresia Casă de piatră:"," https://teratoid-photodiode.000webhostapp.com/Translate/ce%20cau%C8%9Bi.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/cas%C4%83%20de%20piatr%C4%83.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/ce%20dori%C8%9Bi.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/ce%20v%C3%A2rst%C4%83%20ai.gif",2);
        addQuestion2(q25);

        Question2 q26=new Question2("În ce imagine este reprezentată expresia Cred că ne-am mai întâlnit:"," https://teratoid-photodiode.000webhostapp.com/Translate/cred%20c%C4%83%20ne-am%20mai%20%C3%AEnt%C3%A2lnit.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/cum%20ajung%20la.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/Cr%C4%83ciun%20Fericit.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/cum%20te%20sim%C8%9Bi.gif ",1);
        addQuestion2(q26);

        Question2 q27=new Question2("În ce imagine este reprezentată expresia Cine mă caută:"," https://teratoid-photodiode.000webhostapp.com/Translate/ce%20v%C3%A2rst%C4%83%20ave%C8%9Bi.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/cine%20este%20acolo.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/cine%20m%C4%83%20caut%C4%83.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/ce%20dori%C8%9Bi.gif ",3);
        addQuestion2(q27);

        Question2 q28=new Question2("În ce imagine este reprezentată expresia Cum te simți"," https://teratoid-photodiode.000webhostapp.com/Translate/cum%20se%20numeste.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/cum%20te%20cheama.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/cum%20te%20sim%C8%9Bi.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/cu%20pl%C4%83cere.gif ",3);
        addQuestion2(q28);

        Question2 q29=new Question2("În ce imagine este reprezentată expresia Cum se numește:"," https://teratoid-photodiode.000webhostapp.com/Translate/c%C3%A2nd%20a%C8%9Bi%20venit.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/cum%20se%20numeste.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/c%C3%A2t%20este%20ceasul.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/c%C3%A2%C8%9Bi%20ani%20are%20el%20%C8%99i%20ea.gif ",2);
        addQuestion2(q29);

        Question2 q30=new Question2("În ce imagine este reprezentată expresia Câți ani are el si ea:"," https://teratoid-photodiode.000webhostapp.com/Translate/c%C3%A2t%20trebuie%20s%C4%83%20pl%C4%83tesc.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/c%C3%A2nd%20se%20%C3%AEnchide.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/c%C3%A2%C8%9Bi%20ani%20are%20el%20%C8%99i%20ea.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/cu%20pl%C4%83cere.gif ",3);
        addQuestion2(q30);

        Question2 q31=new Question2("În ce imagine este reprezentată expresia Dați-mi voie să mă prezint:"," https://teratoid-photodiode.000webhostapp.com/Translate/da%C8%9Bi-mi%20voie%20s%C4%83%20m%C4%83%20prezint.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/de%20la%20cine%20este.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/dragi%20prieteni.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/de-acord.gif ",1);
        addQuestion2(q31);

        Question2 q32=new Question2("În ce imagine este reprezentată expresia De unde sunteți:"," https://teratoid-photodiode.000webhostapp.com/Translate/de%20unde%20veni%C8%9Bi.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/de%20unde%20sunte%C8%9Bi.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/doamn%C4%83%20a%C8%99%20vrea%20s%C4%83%20face%C8%9Bi%20cuno%C8%99tin%C8%9B%C4%83%20cu%20prietenul%20meu%20domul.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/dup%C4%83%20tine.gif ",2);
        addQuestion2(q32);

        Question2 q33=new Question2("În ce imagine este reprezentată expresia Da sunt absolut sigur:"," https://teratoid-photodiode.000webhostapp.com/Translate/c%C3%A2t%20este%20ceasul.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/da%20sunt%20absolut%20sigur.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/dup%C4%83%20tine.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/doamn%C4%83%20a%C8%99%20vrea%20s%C4%83%20face%C8%9Bi%20cuno%C8%99tin%C8%9B%C4%83%20cu%20prietenul%20meu%20domul.gif ",2);
        addQuestion2(q33);

        Question2 q34=new Question2("În ce imagine este reprezentată expresia E deja târziu:"," https://teratoid-photodiode.000webhostapp.com/Translate/e%20o%20idee%20bun%C4%83.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/e%20adev%C4%83rat.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/e%20deja%20t%C3%A2rziu.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/de-acord.gif ",3);
        addQuestion2(q34);

        Question2 q35=new Question2("În ce imagine este reprezentată expresia E o idee bună:"," https://teratoid-photodiode.000webhostapp.com/Translate/La%20mul%C8%9Bi%20ani.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/la%20revedere.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/fii%20lini%C8%99tit.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/e%20o%20idee%20bun%C4%83.gif ",4);
        addQuestion2(q35);

        Question2 q36=new Question2("În ce imagine este reprezentată expresia Locul acesta este ocupat:"," https://teratoid-photodiode.000webhostapp.com/Translate/locul%20acesta%20este%20ocupat.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/mi-a%20pl%C4%83cut%20foarte%20mult%20aici.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/c%C3%A2%C8%9Bi%20ani%20are%20el%20%C8%99i%20ea.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/de%20unde%20veni%C8%9Bi.gif ",1);
        addQuestion2(q36);

        Question2 q37=new Question2("În ce imagine este reprezentată expresia Mi-a plăcut foarte mult aici:","https://teratoid-photodiode.000webhostapp.com/Translate/am%20%C3%AEn%C8%9Beles.gif"," https://teratoid-photodiode.000webhostapp.com/Translate/mi-a%20pl%C4%83cut%20foarte%20mult%20aici.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/este%20posibil.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/mul%C8%9Bumesc%20bine.gif ",2);
        addQuestion2(q37);

        Question2 q38=new Question2("În ce imagine este reprezentată expresia Fii liniștit:"," https://teratoid-photodiode.000webhostapp.com/Translate/mul%C8%9Bumesc%20bine.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/e%20adev%C4%83rat.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/foarte%20bine.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/fii%20lini%C8%99tit.gif ",4);
        addQuestion2(q38);

        Question2 q39=new Question2("În ce imagine este reprezentată expresia Mă simt foarte descurajat:"," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20am%20g%C4%83sit.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/este%20foarte%20important.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/m%C4%83%20simt%20foarte%20descurajat.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20conteaz%C4%83.gif ",3);
        addQuestion2(q39);

        Question2 q40=new Question2("În ce imagine este reprezentată expresia Nu contează:"," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20m%C4%83%20descurc.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20am%20g%C4%83sit.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20conteaz%C4%83.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20m%C4%83%20intereseaz%C4%83.gif ",3);
        addQuestion2(q40);

        Question2 q41=new Question2("În ce imagine este reprezentată expresia Nu mă interesează:"," https://teratoid-photodiode.000webhostapp.com/Translate/pe%20aici%20v%C4%83%20rog.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20te%20supara.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20pot%20veni%20m%C3%A2ine.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20m%C4%83%20intereseaz%C4%83.gif ",4);
        addQuestion2(q41);

        Question2 q42=new Question2("În ce imagine este reprezentată expresia Pe aici vă rog:"," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20v%C4%83%20face%C8%9Bi%20griji.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/pentru%20cine%20este.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/Scuza%C8%9Bi-m%C4%83%20sunte%C8%9Bi%20domnul.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/pe%20aici%20v%C4%83%20rog.gif ",4);
        addQuestion2(q42);

        Question2 q43=new Question2("În ce imagine este reprezentată expresia Scuzați-mă sunteți domnul:"," https://teratoid-photodiode.000webhostapp.com/Translate/sunt%20din.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/pot%20intra.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/Scuza%C8%9Bi-m%C4%83%20sunte%C8%9Bi%20domnul.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/sunt%20de-acord%20cu%20tine.gif ",3);
        addQuestion2(q43);

        Question2 q44=new Question2("În ce imagine este reprezentată expresia Sunt de-acord cu tine:"," https://teratoid-photodiode.000webhostapp.com/Translate/sunt%20de-acord%20cu%20tine.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/sunt%20foarte%20bine%20mul%C8%9Bumesc.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/spune%C8%9Bi-mi%20v%C4%83%20rog%20c%C3%A2nd%20%C8%99i%20unde%20ne%20putem%20%C3%AEnt%C3%A2lni.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/sper%20s%C4%83%20ne%20vedem%20%C3%AEn%20curand.gif ",1);
        addQuestion2(q44);

        Question2 q45=new Question2("În ce imagine este reprezentată expresia Sper să ne vedem curând:"," https://teratoid-photodiode.000webhostapp.com/Translate/nu%20v%C4%83%20face%C8%9Bi%20griji.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/trebuie%20s%C4%83%20ne%20mai%20%C3%AEnt%C3%A2lnim.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/petrecere%20frumoas%C4%83.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/sper%20s%C4%83%20ne%20vedem%20%C3%AEn%20curand.gif ",4);
        addQuestion2(q45);

        Question2 q46=new Question2("În ce imagine este reprezentată expresia Trebuie să ne mai întâlnim:"," https://teratoid-photodiode.000webhostapp.com/Translate/trebuie%20s%C4%83%20ne%20mai%20%C3%AEnt%C3%A2lnim.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/voi%20doi%20v-a%C8%9Bi%20cunoscut.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/sunt%20foarte%20bine%20mul%C8%9Bumesc.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/locul%20acesta%20este%20ocupat.gif ",1);
        addQuestion2(q46);

        Question2 q47=new Question2("În ce imagine este reprezentată expresia Vă rog poftiți înauntru:"," https://teratoid-photodiode.000webhostapp.com/Translate/vre%C8%9Bi%20s%C4%83%20pofti%C8%9Bi%20%C3%AEnauntru.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/v%C4%83%20rog%20s%C4%83-i%20transmite%C8%9Bi%20complimente.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/%C3%AEmi%20merge%20bine.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/%C8%99tiu%20ca%20e%20adevarat.gif ",1);
        addQuestion2(q47);

        Question2 q48=new Question2("În ce imagine este reprezentată expresia Știu că e adevărat:"," https://teratoid-photodiode.000webhostapp.com/Translate/sunt%20foarte%20bine%20mul%C8%9Bumesc.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/%C3%AEn%20ce%20dat%C4%83%20suntem%20azi.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/v%C4%83%20place%20aici.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/%C8%99tiu%20ca%20e%20adevarat.gif ",4);
        addQuestion2(q48);

        Question2 q49=new Question2("În ce imagine este reprezentată expresia În ce data suntem azi:"," https://teratoid-photodiode.000webhostapp.com/Translate/v%C4%83%20felicit%20pentru%20logodna%20dvs.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/trebuie%20s%C4%83%20refuz.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/%C3%AEn%20ce%20dat%C4%83%20suntem%20azi.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/%C8%99tiu%20ca%20e%20adevarat.gif ",3);
        addQuestion2(q49);

        Question2 q50=new Question2("În ce imagine este reprezentată expresia Îmi convine foarte bine:"," https://teratoid-photodiode.000webhostapp.com/Translate/este%20foarte%20important.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/%C3%AEmi%20merge%20bine.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/v%C4%83%20rog%20s%C4%83%20completa%C8%9Bi%20acest%20formular.gif "," https://teratoid-photodiode.000webhostapp.com/Translate/%C3%AEmi%20convine%20foarte%20bine.gif ",4);
        addQuestion2(q50);
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

    private void addQuestion2(Question2 question2){
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.Questions2Table.COLUMN_QUESTION, question2.getQuestion2());
        cv.put(QuizContract.Questions2Table.COLUMN_OPTION1, question2.getOption12());
        cv.put(QuizContract.Questions2Table.COLUMN_OPTION2, question2.getOption22());
        cv.put(QuizContract.Questions2Table.COLUMN_OPTION3, question2.getOption32());
        cv.put(QuizContract.Questions2Table.COLUMN_OPTION4, question2.getOption42());
        cv.put(QuizContract.Questions2Table.COLUMN_ANSWER_NR, question2.getAnswerNr2());
        db.insert(QuizContract.Questions2Table.TABLE_NAME2, null, cv);
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

    public ArrayList<Question> getQuestionsByCategoryRandom(String category) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String sql="SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME +
                " WHERE " + QuizContract.QuestionsTable.COLUMN_CATEGORY + " = '"+category +"' ORDER BY RANDOM() LIMIT 15";
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
    public ArrayList<Question2> getQuestionQuizAvansat(){
        ArrayList<Question2> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String sql="SELECT * FROM " + QuizContract.Questions2Table.TABLE_NAME2 + " ORDER BY RANDOM() LIMIT 15";
        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            do {
                Question2 question = new Question2();
                question.setQuestion2(c.getString(c.getColumnIndex(QuizContract.Questions2Table.COLUMN_QUESTION)));
                question.setOption12(c.getString(c.getColumnIndex(QuizContract.Questions2Table.COLUMN_OPTION1)));
                question.setOption22(c.getString(c.getColumnIndex(QuizContract.Questions2Table.COLUMN_OPTION2)));
                question.setOption32(c.getString(c.getColumnIndex(QuizContract.Questions2Table.COLUMN_OPTION3)));
                question.setOption42(c.getString(c.getColumnIndex(QuizContract.Questions2Table.COLUMN_OPTION4)));
                question.setAnswerNr2(c.getInt(c.getColumnIndex(QuizContract.Questions2Table.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
