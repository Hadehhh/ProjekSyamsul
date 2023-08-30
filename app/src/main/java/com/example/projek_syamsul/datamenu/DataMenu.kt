package com.example.projek_syamsul.datamenu

import com.example.projek_syamsul.model.ItemKategori

object DataMenu {
    val dataMakananImage = arrayListOf<String>(
        "https://i0.wp.com/tastynesia.com/wp-content/uploads/2022/02/Resep-Batagor.jpg",
        "https://cdn1-production-images-kly.akamaized.net/LQweNFLVDzpRyKwzpFFXipivaHY=/219x0:585x366/1200x1200/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2227836/original/016151400_1527239579-resep-cireng-bumbu-rujak.jpg",
        "https://awsimages.detik.net.id/community/media/visual/2022/08/07/resep-nasi-goreng-ayam-dan-ebi_43.jpeg?w=700&q=90",
        "https://cdn0-production-images-kly.akamaized.net/8EIQ9ILRIx8VHpVj6W65VsOOYdc=/1200x675/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/3103614/original/010560800_1587012414-shutterstock_1565400448.jpg",
        "https://tokobay.com/wp-content/uploads/2022/04/kulit-ayam-crispy-geprek.jpg",
        "https://awsimages.detik.net.id/community/media/visual/2021/11/12/resep-calamari-goreng-tepung_43.jpeg?w=700&q=90"
    )

    val dataMakananNama = arrayListOf<String>(
        "Batagor",
        "Cireng",
        "Nasi Goreng",
        "Soto Ayam",
        "Ayam Geprek",
        "Cumi Goreng Tepung"
    )

    val dataMakananDeskripsi = arrayListOf<String>(
        "Jajanan khas Bandung yang mengadaptasi gaya Tionghoa-Indonesia dan kini sudah dikenal hampir di seluruh wilayah Indonesia.",
        "Makanan ringan yang berasal dari daerah Sunda yang dibuat dengan cara menggoreng campuran adonan yang berbahan utama tepung tapioka.",
        "Makanan berupa nasi yang digoreng dan dicampur dalam minyak goreng, margarin atau mentega.",
        "Makanan khas Indonesia yang berupa sejenis sup ayam dengan kuah yang berwarna kekuningan",
        "Makanan ayam goreng tepung khas Indonesia yang diulek atau dilumatkan bersama sambal bajak.",
        "Cumi-cumi yang digunakan untuk membuat calamari berukuran kecil atau sedang, sehingga ketika dipotong bulat hasilnya tidak kebesaran."
    )

    val dataMakananHarga = arrayListOf<String>(
        "15000",
        "10000",
        "30000",
        "20000",
        "25000",
        "25000"
    )

    val dataMakanan: ArrayList<ItemKategori>
    get() {
        val list = arrayListOf<ItemKategori>()
        for (item in dataMakananNama.indices) {
            list.add(ItemKategori(dataMakananImage[item], dataMakananNama[item], dataMakananDeskripsi[item], dataMakananHarga[item]))
        }
        return list
    }

    val dataMinumanImage = arrayListOf<String>(
        "https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/9d1619df-6393-4fa9-bb0f-1d41cf630d13_41c02b6d-8a4e-4c27-9d2e-4eace92ecf12_Go-Biz_20191210_145643.jpeg",
        "https://awsimages.detik.net.id/community/media/visual/2019/07/01/844ad4d1-38e3-4d89-b45f-f2fb172dcacc.jpeg?w=700&q=90",
        "https://cdn-2.tstatic.net/kaltim/foto/bank/images2/sparklingtea.jpg",
        "https://images.tokopedia.net/img/cache/700/product-1/2020/1/22/5400804/5400804_4866cc12-2042-4f06-8f84-0497dd4cd6d6_1076_1076.jpg",
        "https://img.kurio.network/ykBRZPkfrywQutbvpr2DRfpt7J0=/1200x900/filters:quality(80)/https://kurio-img.kurioapps.com/21/07/04/9222c316-c84d-41b8-b523-25587f2de0fc.jpe",
        "https://asset.kompas.com/crops/LgGmDBxglevUdnCm4fWkEIkVy-U=/0x0:739x493/750x500/data/photo/2020/01/29/5e3187c1ac05f.jpg"
    )

    val dataMinumanNama = arrayListOf<String>(
        "Kopi Hitam",
        "Cappucino",
        "Sparkling Tea",
        "Air Mineral",
        "Lemon Tea",
        "Es Kelapa Muda"
    )

    val dataMinumanDeskripsi = arrayListOf<String>(
        "Minuman yang terbuat dari biji kopi yang disangrai.",
        "Minuman khas Italia yang dibuat dari espreso dan susu,",
        "Minuman perpaduan antara teh dan soda yang menyegarkan",
        "Air mineral berkualitas yang berasal dari mata air pegunungan terpilih.",
        "Teh yang menyegarkan dimana perasan lemon atau irisan lemon ditambahkan dalam teh.",
        "Minuman segar penyejuk dahaga yang terbuat dari daging dan air kelapa yang masih muda."
    )

    val dataMinumanHarga = arrayListOf<String>(
        "10000",
        "15000",
        "15000",
        "5000",
        "20000",
        "17000"
    )

    val dataMinuman: ArrayList<ItemKategori>
    get() {
        val list = arrayListOf<ItemKategori>()
        for (item in dataMinumanNama.indices) {
            list.add(ItemKategori(dataMinumanImage[item], dataMinumanNama[item], dataMinumanDeskripsi[item], dataMinumanHarga[item]))
        }
        return list
    }

    val dataDessertImage = arrayListOf<String>(
        "https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2021/08/17/2033622947.jpg",
        "https://foolproofliving.com/wp-content/uploads/2021/07/Black-rice-salad-recipe-image.jpg",
        "https://amiraspantry.com/wp-content/uploads/2020/08/flan-cake-I.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Ice_cream_with_whipped_cream%2C_chocolate_syrup%2C_and_a_wafer_%28cropped%29.jpg/1200px-Ice_cream_with_whipped_cream%2C_chocolate_syrup%2C_and_a_wafer_%28cropped%29.jpg",
        "https://www.julieseatsandtreats.com/wp-content/uploads/2021/06/How-to-Make-a-Milkshake-Square.jpg",
        "https://awsimages.detik.net.id/community/media/visual/2020/07/01/pancake-amerika-2.jpeg?w=1200"
    )

    val dataDessertNama = arrayListOf<String>(
        "Cheese Cake",
        "Black Salad",
        "Chocolate Cake",
        "Ice Cream",
        "Milkshake",
        "Pancake"
    )

    val dataDessertDeskripsi = arrayListOf<String>(
        "Kue Tart 1 slice dengan bahan utama cream cheese dengan topping buah-buahan asli seperti anggur, jeruk, kiwi.",
        "Makanan yang dihidangkan bersama dressing (sauce)",
        "Cake rasa coklat yang dibuat dengan coklat pilihan.",
        "Makanan beku yang dibuat dari produk susu seperti krim, lalu dicampur dengan perasa dan pemanis.",
        "Minuman dingin dari campuran susu, es krim, dan sirop berperasa yang dikocok hingga berbusa.",
        "Kue yang dibuat dari terigu, telur ayam, gula dan susu."
    )

    val dataDessertHarga = arrayListOf<String>(
        "40000",
        "15000",
        "25000",
        "20000",
        "25000",
        "23000"
    )

    val dataDessert: ArrayList<ItemKategori>
    get() {
        val list = arrayListOf<ItemKategori>()
        for (item in dataDessertNama.indices) {
            list.add(ItemKategori(dataDessertImage[item], dataDessertNama[item], dataDessertDeskripsi[item], dataDessertHarga[item]))
        }
        return list
    }
}