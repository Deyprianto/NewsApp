package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    HashMap<String,String> hashMap ;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);

        createTable();
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);


           View myView = inflater.inflate(R.layout.news_design,viewGroup,false);
           ImageView imgView = myView.findViewById(R.id.imgView);
            TextView tvType = myView.findViewById(R.id.tvType);
            TextView tvHeading = myView.findViewById(R.id.tvHeading);
            TextView tvDesc = myView.findViewById(R.id.tvDesc);
            LinearLayout   layMain = myView.findViewById(R.id.layMain);


            String type = arrayList.get(i).get("type");
            String img_link = arrayList.get(i).get("img_link");
            String heading = arrayList.get(i).get("heading");
            String desc = arrayList.get(i).get("desc");
            tvType.setText(type);
            tvHeading.setText(heading);
            tvDesc.setText(desc);
            String imgLink = arrayList.get(i).get("img_link");

         //   View myView = inflater.inflate(R.layout.news_design,viewGroup,false);
            Glide.with(MainActivity.this)
                    .load(imgLink)
                    // optional
                    .into(imgView);

            layMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, Details_Page.class));
                    Details_Page.title = heading;
                    Details_Page.desc = desc;
                }

                }  );


            return myView;
        }
    }


    private void createTable() {
        hashMap = new HashMap<>();
        hashMap.put("type","Entertainment");
        hashMap.put("img_link","https://media.prothomalo.com/prothomalo-bangla%2F2026-02-20%2Fvlki6ffr%2Feric-dane-greys-062824-1-84e2bb555d234d158c8ccbb5d51574b3.webp?rect=78%2C0%2C633%2C422&w=622&auto=format%2Ccompress&fmt=avif");
        hashMap.put("heading","৫৩ বছর বয়সেই চলে গেলেন ‘গ্রেস অ্যানাটমি’ অভিনেতা");
        hashMap.put("desc","হলিউড অভিনেতা এরিক ডেন মারা গেছেন। ১৯ ফেব্রুয়ারি ৫৩ বছর বয়সী অভিনেতার মৃত্যু হয়। তাঁর পরিবার এক বিবৃতিতে তাঁর মৃত্যুর খবর নিশ্চিত করেছে।\n" +
                "টেলিভিশন দর্শকের কাছে তিনি চিরকাল ‘ম্যাকস্টিমি’ নামেই পরিচিত—মেডিক্যাল ড্রামা ‘গ্রেস অ্যানাটমি’-তে ডা. মার্ক স্লোন চরিত্রে অভিনয় করে যে খ্যাতি তিনি পেয়েছিলেন, তা তাঁকে বিশ্বজুড়ে জনপ্রিয় করে তোলে। সাম্প্রতিক প্রজন্ম তাঁকে নতুন করে চিনেছে এইচবিওর বহুল আলোচিত সিরিজ ‘ইউফোরিয়া’-তে জটিল, দ্বিধাগ্রস্ত পিতা ক্যাল জেকবস চরিত্রে।\n" +
                "\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("type","VASA");
        hashMap.put("img_link","https://media.prothomalo.com/prothomalo-bangla%2F2026-02-21%2Fa0cvjkwi%2FWhatsApp-Image-2026-02-21-at-10.12.25-AM.jpeg?rect=0%2C0%2C1600%2C1067&w=622&auto=format%2Ccompress&fmt=avif");
        hashMap.put("heading","নৃগোষ্ঠীর ভাষা রক্ষায় কাজ করে তারা");
        hashMap.put("desc","নৃগোষ্ঠীর ভাষা রক্ষায় কাজ করে তারা‘তিনটিকিয়া’ ভাষার বর্ণমালা ছিল না। কোচদের ভয় ছিল, তাদের এই ভাষা বুঝি হারিয়ে যাবে। সেই ভীতি অমূলক ছিল না হয়তো। কারণ, নতুন প্রজন্মের মধ্যে নিজ ভাষার ব্যবহার অনেকটাই কমে যাচ্ছিল। সেটা অনুভব করতেন অমৃত কোচের মতো অনেকেই। তাঁর বাড়ি শেরপুর জেলার ঝিনাইগাতী উপজেলার শালচোরা গ্রামে। এখানে ২৮ কোচ পরিবারের বাস। আশপাশের তিন-চারটি গ্রামও কোচ সংখ্যাগরিষ্ঠ। অমৃত কোচ বলছিলেন, ‘একটি বর্ণমালার দরকার ছিল। সেই বর্ণমালা এখন পেয়েছি। হয়তো এটা আমাদের ভাষার সুরক্ষায় কাজ করবে। বাংলাদেশে যে ৫০টির বেশি জনজাতিগোষ্ঠী আছে, তাদের মধ্যে কোচ একটি। ২০২২ সালের জনশুমারি অনুযায়ী, কোচদের সংখ্যা ১৩ হাজার ৭০২। এত কম সংখ্যায় মানুষের ভাষা বিপন্ন প্রায়। শুধু কোচদের নয়, বাংলাদেশে ৫০টির বেশি নৃগোষ্ঠীর প্রতিটির ভাষাই বিপন্ন। সংখ্যায় যারা বেশি যেমন চাকমা, মারমা, ত্রিপুরা বা সান্তাল—তাদের ভাষা হারিয়ে যাওয়ার ঝুঁকি কিছুটা কম। কিন্তু কোচদের মতো জনসংখ্যার বিচারে ছোট জনগোষ্ঠীর ঝুঁকি অনেকটাই বেশি। এসব ভাষা একেবারে যাতে হারিয়ে না যায়, তাই ভাষাগুলোর বর্ণমালা ও বানানরীতি তৈরি করছে আন্তর্জাতিক সংগঠন সামার ইনস্টিটিউট");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("type","Business");
        hashMap.put("img_link","https://media.prothomalo.com/prothomalo-bangla%2F2026-02-20%2Frdzkq2i4%2FWhatsApp-Image-2026-02-20-at-11.07.13-PM.jpeg?rect=126%2C0%2C1349%2C899&w=622&auto=format%2Ccompress&fmt=avif");
        hashMap.put("heading","দেশে শর্ষে উৎপাদনের শীর্ষে সিরাজগঞ্জ জেলা");
        hashMap.put("desc","শর্ষে উৎপাদনে দেশের শীর্ষ জেলা সিরাজগঞ্জ। এ জেলার পাশ দিয়ে বয়ে গেছে বাংলাদেশের বৃহত্তম বিল চলনবিল। এ বিলের পানিমিশ্রিত পলিমাটিই জেলাটিকে সারা দেশ থেকে আলাদা করেছে। মাটির এ উর্বরতা সিরাজগঞ্জকে শর্ষে আবাদের সবচেয়ে উপযোগী স্থানে পরিণত করেছে বলে মনে করছেন কৃষিবিদেরা।\n" +
                "\n" +
                "বৃহৎ এ বিলকে কেন্দ্র করে সিরাজগঞ্জে আরও ৫২টি ছোট–বড় বিল বয়ে গেছে। বর্ষায় এসব বিলের পানি বিস্তৃত হয়ে ছড়িয়ে পড়ে চারদিকে। তবে শুষ্ক মৌসুমে পানির নিচ থেকে জেগে ওঠা জমিতে আবার ফসলের আবাদ হয়। এ কারণেই জেলা সদর থেকে উল্লাপাড়া, শাহজাদপুর, বেলকুচি ও তাড়াশ—যেদিকেই পথ যায়, শুধু শর্ষের হলুদের সমারোহ।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("type","Information");
        hashMap.put("img_link","https://media.prothomalo.com/prothomalo-bangla%2F2026-02-16%2Fsjo7r7le%2Fpexels_padrinan_971078.jpg?rect=559%2C0%2C3272%2C2181&w=622&auto=format%2Ccompress&fmt=avif");
        hashMap.put("heading",
                "যেভাবে বাদাম ও বীজ খেলে সবচেয়ে বেশি উপকার পাবেন");
        hashMap.put("desc","বাদাম ও অন্যান্য বীজ নিঃসন্দেহে স্বাস্থ্যকর খাবার। তবে অতিরিক্ত খেলে এ ধরনের খাবার থেকে পাওয়া ক্যালরির কারণেও ওজন নিয়ন্ত্রণ মুশকিল হতে পারে। এ ছাড়া ভুল পদ্ধতিতে খাওয়া হলে উপকার না-ও মিলতে পারে। এমনকি কোনো কোনো ক্ষেত্রে ক্ষতির কারণও হয়ে দাঁড়াতে পারে। এ সম্পর্কে টাঙ্গাইলের কুমুদিনী সরকারি কলেজের গার্হস্থ্য অর্থনীতি বিভাগের প্রধান অধ্যাপক শম্পা শারমিন খান-এর সঙ্গে কথা বলে লিখেছেন রাফিয়া আলম।\n" +
                "\n নিচ থেকে জেগে ওঠা জমিতে আবার ফসলের আবাদ হয়। এ কারণেই জেলা সদর থেকে উল্লাপাড়া, শাহজাদপুর, বেলকুচি ও তাড়াশ—যেদিকেই পথ যায়, শুধু শর্ষের হলুদের সমারোহ।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("type","International");
        hashMap.put("img_link","https://media.prothomalo.com/prothomalo-bangla%2F2026-01-27%2F3nm598zf%2Fuss.jpg?rect=132%2C0%2C588%2C392&w=622&auto=format%2Ccompress&fmt=avif");
        hashMap.put("heading","\n" +
                "ইরানে হামলার আশঙ্কায় উত্তেজনা");
        hashMap.put("desc","মধ্যপ্রাচ্যে বিমানবাহী রণতরি ইউএসএস আব্রাহাম লিংকনসহ গুরুত্বপূর্ণ সামরিক সরঞ্জাম মোতায়েন করেছে যুক্তরাষ্ট্র। পর্যবেক্ষকদের মতে, এর মাধ্যমে ইসরায়েলের সঙ্গে যৌথভাবে ইরানে বড় ধরনের ক্ষেপণাস্ত্র হামলার প্রস্তুতি নিচ্ছে ওয়াশিংটন। সংশ্লিষ্ট ব্যক্তিরা মনে করছেন, ইরান সরকারের পতন ঘটানোর লক্ষ্যেই এ বিশাল সামরিক শক্তি জড়ো করা হচ্ছে। তেহরানের বিরুদ্ধে চলমান বিক্ষোভ সহিংসভাবে দমন এবং হাজার হাজার ইরানি নাগরিককে হত্যার অভিযোগ রয়েছে।\n" +
                "\n" +
                "যুক্তরাষ্ট্রের ক্ষেপণাস্ত্র ধ্বংসকারী রণতরিগুলো এখনো চূড়ান্ত অবস্থানে না পৌঁছালেও ইরানের ওপর আঘাত হানার সীমানার মধ্যেই রয়েছে। তবে মার্কিন হামলায় ইরানে নতুন করে সরকারবিরোধী বিক্ষোভ দানা বাঁধবে কি না, তা নিয়ে সংশয় রয়েছে। কারণ, ১৯৭৯ সাল থেকে ক্ষমতায় থাকা কট্টরপন্থী নেতৃত্বের বিরোধী হলেও অনেক ইরানি বিদেশি শক্তির মাধ্যমে সরকার পরিবর্তনের পক্ষপাতী নন।শুধু শর্ষের হলুদের সমারোহ।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("type","International");
        hashMap.put("img_link","https://media.prothomalo.com/prothomalo-bangla%2F2026-02-21%2F8hoq9smy%2FWhatsApp-Image-2026-02-21-at-7.38.53-PM.jpeg?rect=130%2C0%2C1341%2C894&w=622&auto=format%2Ccompress&fmt=avif");
        hashMap.put("heading",
                "নড়াইলে আওয়ামী লীগের ইউনিয়ন কার্যালয়ে জাতীয় পতাকা উত্তোলন");
        hashMap.put("desc","নড়াইলের লোহাগড়া উপজেলায় কার্যক্রম নিষিদ্ধ আওয়ামী লীগের একটি ইউনিয়ন কার্যালয়ের সামনে জাতীয় পতাকা উত্তোলন করা হয়েছে। আজ শনিবার সকালে লোহাগড়া উপজেলার মানিকগঞ্জ বাজারে নোয়াগ্রাম ইউনিয়ন আওয়ামী লীগের কার্যালয়ের সামনে জাতীয় পতাকা উত্তোলন করেন দলটির নেতা-কর্মীরা।\n" +
                "\n" +
                "এর আগে ১৭ ফেব্রুয়ারি রাতে লোহাগড়া উপজেলা শহরের জয়পুর জামরুলতলা এলাকায় উপজেলা আওয়ামী লীগের কার্যালয়ের সামনে জাতীয় পতাকা উত্তোলন করা হয়েছিল। একই সঙ্গে উপজেলা কার্যালয়ের দেয়ালে বঙ্গবন্ধু শেখ মুজিবুর রহমান ও ক্ষমতাচ্যুত সাবেক প্রধানমন্ত্রী শেখ হাসিনার ছবি টাঙানো হয়েছিল। পরে এ-সংক্রান্ত একটি ভিডিও ফেসবুকে ছড়িয়ে পড়লে ছবি ও পতাকা সরিয়ে ফেলা হয়।করে সরকারবিরোধী বিক্ষোভ দানা বাঁধবে কি না, তা নিয়ে সংশয় রয়েছে। কারণ, ১৯৭৯ সাল থেকে ক্ষমতায় থাকা কট্টরপন্থী নেতৃত্বের বিরোধী হলেও অনেক ইরানি বিদেশি শক্তির মাধ্যমে সরকার পরিবর্তনের পক্ষপাতী নন।শুধু শর্ষের হলুদের সমারোহ।");
        arrayList.add(hashMap);


    }
}