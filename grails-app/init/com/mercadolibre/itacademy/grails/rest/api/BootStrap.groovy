package com.mercadolibre.itacademy.grails.rest.api

import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        def marca1 = new Marca(name: "Iphone").save(flush:true);
        def marca2 = new Marca(name: "Samsung").save(flush:true);

        marca1.addToArticulos(new Articulo(
                name: "iphone 7",
                picture: 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone7-black-select-2016?wid=940&hei=1112&fmt=png-alpha&qlt=80&.v=1550795419952',
                total_items_in_this_category: 15,
        )).save();

        marca1.addToArticulos(new Articulo(
                name: "MacBook Pro",
                picture: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHQDGwQ6V3Nw9-ZbnwQyr5ubTIspkfQ2_BjA4fB-JJQVigWXm9yg',
                total_items_in_this_category: 7,
        )).save();
        marca1.addToArticulos(new Articulo(
                name: "earpods",
                picture: 'https://static.turbosquid.com/Preview/2016/11/14__05_21_17/AppleAirPodsSetc4dmodel001.jpgAF964D35-8784-42D7-9442-67DC83665CF0Original.jpg',
                total_items_in_this_category: 20,
        )).save();

        marca2.addToArticulos(new Articulo(
                name: "S10",
                picture: 'https://static.turbosquid.com/Preview/2019/04/21__02_20_23/02.jpg0A08E65D-8EAE-48A4-A0DC-80BF79A2BE32Default.jpg',
                total_items_in_this_category: 8,
        )).save();
        marca2.addToArticulos(new Articulo(
                name: "QLED TV",
                picture: 'https://bestsmarttvreview.files.wordpress.com/2018/08/samsung-65-inch-q6f-qled-tv-2.jpg?w=1100',
                total_items_in_this_category: 7,
        )).save();
        marca2.addToArticulos(new Articulo(
                name: "smartwatch",
                picture: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCc6uZQ8r_-fZd2DguY1w0Lfw8wjsrASSYItFQW9AVnsmLk8pt8A',
                total_items_in_this_category: 20,
        )).save();

        marshaller();

    }
    def destroy = {
    }

    private void marshaller() {
        JSON.registerObjectMarshaller(Marca) {
            marca -> [
                    id: marca.id,
                    name: marca.name,
            ]
        }
        JSON.registerObjectMarshaller(Articulo) {
            articulo -> [
                    id: articulo.id,
                    name: articulo.name,
                    picture: articulo.picture,
                    total_items_in_this_category: articulo.total_items_in_this_category,
                    children_categories: []
            ]
        }
    }

}
