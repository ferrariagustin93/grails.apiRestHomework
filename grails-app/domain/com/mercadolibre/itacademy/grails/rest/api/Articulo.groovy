package com.mercadolibre.itacademy.grails.rest.api

import grails.rest.Resource

@Resource(uri='/articulos')
class Articulo {
    String name
    String picture
    int total_items_in_this_category
    static belongsTo = [marca:Marca]

    static constraints = {
        name blank: false, nullable: false;
    }
}
