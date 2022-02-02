package com.example.common



data class ForeCastResponse(
    val code: String ?= "test",
    val count: Int,
    val list: List<forecast>,
    val message: String
)


data class forecast(
    val cbssu: String,
    val cbssu_bus: String,
    val cdgsu: String,
    val cdgsu_bus: String,
    val cdjsu: String,
    val cdjsu_bus: String,
    val cgjsu: String,
    val cgjsu_bus: String,
    val cjibangDir: String,
    val cjunkook: String,
    val ckrsu: String,
    val ckrsu_bus: String,
    val cmpsu: String,
    val cmpsu_bus: String,
    val cseoulDir: String,
    val csubs: String,
    val csubs_bus: String,
    val csudg: String,
    val csudg_bus: String,
    val csudj: String,
    val csudj_bus: String,
    val csugj: String,
    val csugj_bus: String,
    val csukr: String,
    val csukr_bus: String,
    val csump: String,
    val csump_bus: String,
    val csuus: String,
    val csuus_bus: String,
    val csuyy: String,
    val csuyy_bus: String,
    val cussu: String,
    val cussu_bus: String,
    val cyysu: String,
    val cyysu_bus: String,
    val sdate: String,
    val stime: String
)