package com.rameses.dicodingsubmissionwisatatabanan;

import java.util.ArrayList;

public class TourismData {
    private static String[] tourismNames = {
            "Kebun Raya Bedugul",
            "Pura Tanah Lot",
            "Pura Alas Kedaton",
            "Bali Butterfly Park",
            "Pantai Soka",
            "Pantai Kelating",
            "Wisata Air Panas Angseri",
            "Air Terjun Blahmantung",
            "Air Terjun Yeh Ho",
            "Danau Beratan"

    };

    private static String[] tourismLocations = {
            "Banjar Bukit Catu, Candikuning, Baturiti, Kabupaten Tabanan, Bali.",
            "Beraban, Kediri, Kabupaten Tabanan, Bali.",
            "Jl. Raya Alas Kedaton, Kukuh, Kecamatan Tabanan, Kabupaten Tabanan, Bali.",
            "Sandan Lebah, Sesandan, Kabupaten Tabanan, Bali.",
            "Jl. Raya Denpasar-Gilimanuk, Antap, Selemadeg, Kabupaten Tabanan, Bali.",
            "Kelating, Kerambitan, Kabupaten Tabanan, Bali.",
            "Desa Angseri, Kecamatan Baturiti, Kabupaten Tabanan, Bali.",
            "Pujungan, Pupuan, Kabupaten Tabanan, Bali.",
            "Jl. Batu Luwih Kawan, Jatiluwih, Penebel, Kabupaten Tabanan, Bali.",
            "Candikuning, Baturiti, Kabupaten Tabanan, Bali."
    };

    private static int[] tourismDetails = {
        R.string.toruism_detail_bedugul,
        R.string.toruism_detail_tanahlot,
        R.string.tourism_detail_alaskedaton,
        R.string.tourism_detail_butterflypark,
        R.string.tourism_detail_pantaisoka,
        R.string.tourism_detail_pantaikelanting,
        R.string.tourism_detail_airpanasangseri,
        R.string.tourism_detail_airterjunblahmantung,
        R.string.tourism_detail_airterjunyehho,
        R.string.tourism_detail_danauberatan
    };

    private static int[] tourismImages = {
        R.drawable.bedugul,
        R.drawable.tanahlot,
        R.drawable.alaskedaton,
        R.drawable.butterfly,
        R.drawable.soka,
        R.drawable.kelanting,
        R.drawable.angseri,
        R.drawable.blemantung,
        R.drawable.yeho,
        R.drawable.danauberatan
    };

    static ArrayList<Tourism> getListData() {
        ArrayList<Tourism> list = new ArrayList<>();
        for (int position = 0; position < tourismNames.length; position++) {
            Tourism tourism = new Tourism();
            tourism.setTourism_name(tourismNames[position]);
            tourism.setTourism_location(tourismLocations[position]);
            tourism.setTourism_detail(tourismDetails[position]);
            tourism.setTourism_photo(tourismImages[position]);
            list.add(tourism);
        }
        return list;
    }
}
