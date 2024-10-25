package com.example.mykotlinlist

class BestMoviesPovider {
    companion object{
        val bestMoviesLists = listOf (
           /* BestMovies("Lecha Entera (Mercadona)","2014","169 min.","United States","Christopher Nolan","Ciencia ficción,Aventura","https://i.pinimg.com/originals/8c/47/fd/8c47fd45c8b3cb2521a504ab6e5f34df.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            BestMovies("Joker","2019","121 min.","United States","Todd Phillips","Thriller,Drama","https://i.pinimg.com/564x/0f/a2/85/0fa28529e8d5819e3db7a806c6e02aaa.jpg","https://youtu.be/ygUHhImN98w","https://www.filmaffinity.com/es/film966850.html"),
            BestMovies("Parasitos","2019","132 min.","South Korea","Bong Joon Ho","Thriller,Drama","https://i.pinimg.com/564x/e6/de/03/e6de035cd3307b513e9bfe88a1457826.jpg","https://youtu.be/90dWVETAdtI","https://www.filmaffinity.com/es/film966850.html"),
            BestMovies("The wolf of Wall Street","2013","180 min.","United States","Martin Scorsese","Drama,Comedia","https://i.pinimg.com/564x/e4/69/23/e469239a7c693996965c1fa85be538d2.jpg","https://youtu.be/DEMZSa0esCU","https://www.filmaffinity.com/es/film916987.html"),
            BestMovies("La La Land","2016","128 min.","United States","Damien Chazelle","Comedia,Musical","https://i.pinimg.com/736x/49/3e/2c/493e2c1109f2e72f745eb7880d75e7fe.jpg","https://youtu.be/IHbHn5SLhZo","https://www.filmaffinity.com/es/film916987.html"),
            BestMovies("Avengers: Infinity War","2018","149 min.","United States","Anthony Russo,Joe Russo","Ciencia ficción,Aventura","https://i.pinimg.com/564x/6f/78/ea/6f78ea546520f8dc76356945393c1cf3.jpg","https://www.youtube.com/embed/6ZfuNTqbHE8","https://www.filmaffinity.com/es/film916987.html"),
            BestMovies("The Revenant","2015","156 min.","United States","Alejandro G. Iñárritu","Drama,Aventura","https://i.pinimg.com/564x/d3/40/bf/d340bf61b9dc80ac2382312dba95a005.jpg","https://www.youtube.com/embed/LoebZZ8K5N0","https://www.filmaffinity.com/es/film916987.html"),
            BestMovies("Avengers: Endgame","2019","181 min.","United States","Anthony Russo,Joe Russo","Ciencia ficción,Aventura","https://i.pinimg.com/564x/24/05/f5/2405f5d1220d45fef53df0bfe804e104.jpg","https://www.youtube.com/embed/TcMBFSGVi1c","https://www.filmaffinity.com/es/film916987.html"),
            BestMovies("Room","2015","118 min.","United States","Lenny Abrahamson","Drama","https://i.pinimg.com/564x/d7/0a/73/d70a736ec9ee03239adf0834f9a06d50.jpg","https://www.youtube.com/embed/8s4h9MR0Ng4","https://www.filmaffinity.com/es/film916987.html"),
            BestMovies("Ex Machina","2014","108 min.","United Kingdom","Alex Garland","Ciencia ficción,Drama","https://i.pinimg.com/564x/c0/4a/a9/c04aa9697781b6becb82007484c4c71e.jpg","https://www.youtube.com/embed/EoQuVnKhxaM","https://www.filmaffinity.com/es/film916987.html"),
*/
            BestMovies("Leche Entera","Leche y huevos","Mercadona","5,48€/6x1 | 0,91€/1L","https://i.pinimg.com/originals/8c/47/fd/8c47fd45c8b3cb2521a504ab6e5f34df.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            //continemos con el resto de productos indispensables para el hogar
            BestMovies("Huevos","Leche y huevos","Mercadona","1,99€/12 | 0,17€/1","https://images.openfoodfacts.org/images/products/842/346/260/0007/front_es.64.full.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            BestMovies("Huevos","Leche y huevos","Lidl","1,99€/12 | 0,17€/1","https://s1.ppllstatics.com/ideal/www/multimedia/201805/21/media/cortadas/huevos-camperos-lidl-kHDD-U501977550333k1G-624x385@Ideal.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            BestMovies("Leche Entera","Leche y huevos","Carrefour","5,48€/6x1 | 0,91€/1L","https://static.carrefour.es/hd_510x_/img_pim_food/231395_00_1.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            //supermercado El Cabo producto azucar
            BestMovies("Azucar","Azucar y edulcorantes","El Cabo","1,99€/1kg | 0,17€/1","https://supermercadoselcabo.es/wp-content/uploads/2020/07/azucar-blanco-sidul.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            //leche entera supermercado Mas y Mas
            BestMovies("Atún en aceite de oliva","Atún y conservas","Mercadona","5,02€/6x80g | 0,83€/1","https://a0.soysuper.com/cef58ce9ac8a990c23b97b576132ebcb.1500.0.0.0.wmark.da802073.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            BestMovies("Leche Entera","Leche y huevos","Lidl","5,48€/6x1 | 0,91€/1L","https://s1.eestatic.com/2021/01/22/actualidad/553206337_171066380_864x486.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            BestMovies("Leche Entera","Leche y huevos","Mas y Mas","5,48€/6x1 | 0,91€/1L","https://cdn.aktiosdigitalservices.com/tol/fornes/catalog/product/media/img/1600x1600/08411700026139.jpg?t=20221015050008","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            BestMovies("Atún en aceite de oliva","Atún y conservas","Lidl","1,99€/3x80g | 0,83€/1","https://www.merca2.es/wp-content/uploads/2020/06/atun-claro-en-aceite-de-oliva-1-600x450.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            BestMovies("Huevos","Leche y huevos","Lidl","1,99€/12 | 0,17€/1","https://s1.ppllstatics.com/ideal/www/multimedia/201805/21/media/cortadas/huevos-camperos-lidl-kHDD-U501977550333k1G-624x385@Ideal.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            BestMovies("Leche Entera","Leche y huevos","Carrefour","5,48€/6x1 | 0,91€/1L","https://static.carrefour.es/hd_510x_/img_pim_food/231395_00_1.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            BestMovies("Huevos","Leche y huevos","Carrefour","1,99€/12 | 0,17€/1","https://static.carrefour.es/hd_350x_/img_pim_food/753697_00_1.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            //azucar carrefour cambia de precio
            BestMovies("Azucar","Azucar y edulcorantes","Carrefour","1,99€/1kg | 0,17€/1","https://static.carrefour.es/hd_510x_/img_pim_food/463155_00_1.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),
            //leche entera carrefour cambia de precio
            BestMovies("Leche Entera","Leche y huevos","Dia","5,48€/6x1 | 0,91€/1L","https://s3.dia.es/medias/productimages/ha8/hbd/10717081993246.jpg","https://youtu.be/UoSSbmD9vqc","https://www.filmaffinity.com/es/film704416.html"),


            )
    }
}