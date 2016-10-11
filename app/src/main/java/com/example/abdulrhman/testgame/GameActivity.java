package com.example.abdulrhman.testgame;

import android.content.Intent;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
String mword;
    int counterFailed=0;
    int guessletter=0;
    int point=0;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        result=(TextView)findViewById(R.id.Tex);
        setRondmWord();

    }
    public void checkletter(View view){
        EditText editText=(EditText) findViewById(R.id.editText);
        String letter=editText.getText().toString();
        editText.setText("");
        Log. d("MyLog","My Letter is "+letter);
        if (letter.length()==1){
            checks(letter.toUpperCase());
        }
        else{
            Toast.makeText(this,"pleas enter one letter ",Toast.LENGTH_LONG).show();
        }

    }

    public void checks(String letters) {
        boolean result_letter = false;
        char words = letters.charAt(0);
        for (int i = 0; i < mword.length(); i++) {
            char testletter = mword.charAt(i);
            if (testletter == words) {
                Log.d("Test", "letter is " + testletter);
                result_letter = true;
                showLetterIndex(i, testletter);
                guessletter++;

            }


        }
        if (result_letter == false) {
            letterfailed(words + "");

        }
        if (guessletter == mword.length()) {
            point++;
            clearScreen();
            setRondmWord();

        }
    }

        public void clearScreen(){
        result.setText("");
        counterFailed=0;
        guessletter=0;
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.layoutletter);
        for (int i=0;i<linearLayout.getChildCount();i++){
            TextView textView= (TextView) linearLayout.getChildAt(i);
            textView.setText("-");
        }
            ImageView imageView=(ImageView)findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.hangdroid_0);
    }



    public void showLetterIndex(int index,char letterguessed){
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.layoutletter);
        TextView textView= (TextView) linearLayout.getChildAt(index);
        textView.setText(letterguessed+"");



    }
    public void letterfailed(String letter) {
        counterFailed += 1;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        String phletter = result.getText().toString();
        result.setText(phletter + letter);
        switch (counterFailed) {
            case 1:
                imageView.setImageResource(R.drawable.hangdroid_1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.hangdroid_2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.hangdroid_3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.hangdroid_4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.hangdroid_5);
                break;
            case 6:
                Intent intent = new Intent(GameActivity.this, GameOver.class);
                intent.putExtra("point", point);
                startActivity(intent);
              finish();
                break;


        }
    }
        public void setRondmWord(){
            String word="AAHS AALS ABAC ABAS ABBA ABBE ABBS ABED ABET ABID ABLE ABLY ABOS ABRI ABUT ABYE ABYS ACAI ACCA ACED ACER ACES ACHE ACHY ACID ACME ACNE ACRE ACTA ACTS ACYL ADAW ADDS ADDY ADIT ADOS ADRY ADZE AEON AERO AERY AESC AFAR AFFY AFRO AGAR AGAS AGED AGEE AGEN AGER AGES AGHA AGIN AGIO AGLU AGLY AGMA AGOG AGON AGUE AHED AHEM AHIS AHOY AIAS AIDE AIDS AIGA AILS AIMS AINE AINS AIRN AIRS AIRT AIRY AITS AITU AJAR AJEE AKED AKEE AKES AKIN ALAE ALAN ALAP ALAR ALAS ALAY ALBA ALBE ALBS ALCO ALEC ALEE ALEF ALES ALEW ALFA ALFS ALGA ALIF ALIT ALKO ALKY ALLS ALLY ALMA ALME ALMS ALOD ALOE ALOW ALPS ALSO ALTO ALTS ALUM AMAH AMAS AMBO AMEN AMIA AMID AMIE AMIN AMIR AMIS AMLA AMMO AMOK AMPS AMUS AMYL ANAL ANAN ANAS ANCE ANDS ANES ANEW ANGA ANIL ANIS ANKH ANNA ANNO ANNS ANOA ANON ANOW ANSA ANTA ANTE ANTI ANTS ANUS APAY APED APER APES APEX APOD APOS APPS APSE APSO APTS AQUA ARAK ARAR ARBA ARBS ARCH ARCO ARCS ARDS AREA ARED AREG ARES ARET AREW ARFS ARIA ARID ARIL ARIS ARKS ARLE ARMS ARMY ARNA AROW ARPA ARSE ARSY ARTI ARTS ARTY ARUM ARVO ARYL ASAR ASCI ASEA ASHY ASKS ASPS ATAP ATES ATMA ATOC ATOK ATOM ATOP ATUA AUFS AUKS AULA AULD AUNE AUNT AURA AUTO AVAL AVAS AVEL AVER AVES AVID AVOS AVOW AWAY AWDL AWED AWEE AWES AWLS AWNS AWNY AWOL AWRY AXAL AXED AXEL AXES AXIL AXIS AXLE AXON AYAH AYES AYIN AYRE AYUS AZAN AZON AZYM BAAL BAAS BABA BABE BABU BABY BACH BACK BACS BADE BADS BAEL BAFF BAFT BAGH BAGS BAHT BAIL BAIT BAJU BAKE BALD BALE BALK BALL BALM BALS BALU BAMS BANC BAND BANE BANG BANI BANK BANS BANT BAPS BAPU BARB BARD BARE BARF BARK BARM BARN BARP BARS BASE BASH BASK BASS BAST BATE BATH BATS BATT BAUD BAUK BAUR BAWD BAWL BAWN BAWR BAYE BAYS BAYT BEAD BEAK BEAM BEAN BEAR BEAT BEAU BECK BEDE BEDS BEDU BEEF BEEN BEEP BEER BEES BEET BEGO BEGS BEIN BELL BELS BELT BEMA BEND BENE BENI BENJ BENS BENT BERE BERG BERK BERM BEST BETA BETE BETH BETS BEVY BEYS BHAT BHEL BHUT BIAS BIBB BIBS BICE BIDE BIDI BIDS BIEN BIER BIFF BIGA BIGG BIGS BIKE BILE BILK BILL BIMA BIND BINE BING BINK BINS BINT BIOG BIOS BIRD BIRK BIRL BIRO BIRR BISE BISH BISK BIST BITE BITO BITS BITT BIZE BLAB BLAD BLAE BLAG BLAH BLAM BLAT BLAW BLAY BLEB BLED BLEE BLET BLEW BLEY BLIN BLIP BLOB BLOC BLOG BLOT BLOW BLUB BLUE BLUR BOAB BOAK BOAR BOAS BOAT BOBA BOBS BOCK BODE BODS BODY BOEP BOET BOFF BOGS BOGY BOHO BOHS BOIL BOIS BOKE BOKO BOKS BOLA BOLD BOLE BOLL BOLO BOLT BOMA BOMB BONA BOND BONE BONG BONK BONY BOOB BOOH BOOK BOOL BOOM BOON BOOR BOOS BOOT BOPS BORA BORD BORE BORK BORM BORN BORS BORT BOSH BOSK BOSS BOTA BOTH BOTS BOTT BOUK BOUN BOUT BOWL BOWR BOWS BOXY BOYF BOYG BOYO BOYS BOZO BRAD BRAE BRAG BRAK BRAN BRAS BRAT BRAW BRAY BRED BREE BREI BREN BRER BREW BREY BRIE BRIG BRIK BRIM BRIN BRIO BRIS BRIT BROD BROG BROO BROS BROW BRRR BRUS BRUT BRUX BUAT BUBA BUBO BUBS BUBU BUCK BUDA BUDI BUDO BUDS BUFF BUFO BUGS BUHL BUHR BUIK BUKE BULB BULK BULL BUMF BUMP BUMS BUNA BUND BUNG BUNK BUNN BUNS BUNT BUOY BURA BURB BURD BURG BURK BURL BURN BURP BURR BURS BURY BUSH BUSK BUSS BUST BUSY BUTE BUTS BUTT BUYS BUZZ BYDE BYES BYKE BYRE BYRL BYTE CAAS CABA CABS CACA CADE CADI CADS CAFE CAFF CAGE CAGS CAGY CAID CAIN CAKE CAKY CALF CALK CALL CALM CALO CALP CALX CAMA CAME CAMO CAMP CAMS CANE CANG CANN CANS CANT CANY CAPA CAPE CAPH CAPI CAPO CAPS CARB CARD CARE CARK CARL CARN CARP CARR CARS CART CASA CASE CASH CASK CAST CATE CATS CAUF CAUK CAUL CAUM CAUP CAVA CAVE CAVY CAWK CAWS CAYS CEAS CECA CEDE CEDI CEES CEIL CELL CELS CELT CENS CENT CEPE CEPS CERE CERO CERT CESS CETE CHAD CHAI CHAL CHAM CHAO CHAP CHAR CHAS CHAT CHAV CHAW CHAY CHEF CHER CHEW CHEZ CHIA CHIB CHIC CHID CHIK CHIN CHIP CHIS CHIT CHIV CHIZ CHOC CHOG CHON CHOP CHOU CHOW CHUB CHUG CHUM CHUT CIAO CIDE CIDS CIEL CIGS CILL CINE CION CIRE CIRL CIST CITE CITO CITS CITY CIVE CLAD CLAG CLAM CLAN CLAP CLAT CLAW CLAY CLEF CLEG CLEM CLEW CLIP CLOD CLOG CLON CLOP CLOT CLOU CLOW CLOY CLUB CLUE COAL COAT COAX COBB COBS COCA COCH COCK COCO CODA CODE CODS COED COFF COFT COGS COHO COIF COIL COIN COIR COIT COKE COKY COLA COLD COLE COLL COLS COLT COLY COMA COMB COME COMM COMP COMS COND CONE CONF CONI CONK CONN CONS CONY COOF COOK COOL COOM COON COOP COOS COOT COPE COPS COPY CORD CORE CORF CORK CORM CORN CORS CORY COSE COSH COSS COST COSY COTE COTH COTS COTT COUP COUR COVE COWK COWL COWP COWS COWY COXA COXY COYS COZE COZY CRAB CRAG CRAM CRAN CRAP CRAW CRAY CRED CREE CREM CREW CRIB CRIM CRIS CRIT CROC CROG CROP CROW CRUD CRUE CRUS CRUX CUBE CUBS CUDS CUED CUES CUFF CUIF CUIT CUKE CULL CULM CULT CUNT CUPS CURB CURD CURE CURF CURL CURN CURR CURS CURT CUSH CUSK CUSP CUSS CUTE CUTS CWMS CYAN CYMA CYME CYST CYTE CZAR DABS DACE DACK DADA DADO DADS DAES DAFF DAFT DAGO DAGS DAHL DAHS DAIS DAKS DALE DALI DALS DALT DAME DAMN DAMP DAMS DANG DANK DANS DANT DAPS DARB DARE DARG DARI DARK DARN DART DASH DATA DATE DATO DAUB DAUD DAUR DAUT DAVY DAWD DAWK DAWN DAWS DAWT DAYS DAZE DEAD DEAF DEAL DEAN DEAR DEAW DEBE DEBS DEBT DECK DECO DEED DEEK DEEM DEEN DEEP DEER DEES DEET DEEV DEFI DEFT DEFY DEGS DEID DEIF DEIL DEKE DELE DELF DELI DELL DELO DELS DELT DEME DEMO DEMY DENE DENI ";
            String[]word_game=word.split(" ");
            Log.d("the Lenght ", String.valueOf(word_game.length));
            int rondum=(int)(Math.random()*word_game.length);
            mword=word_game[rondum];


    }

    }

