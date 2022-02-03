package com.example.data

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

data class GetTradingDataRequest ( //추후 수정 필요
    var LAWD_CD: String ?= null,
    var DEAL_YMD: String ?= null,
    var serviceKey: String ?= null
)

/** Response */
@Xml(name = "response")
data class GetTradingDataResponse (
    @Element
    val header: Header ?= null,
    @Element
    val body: Body ?= null
)

@Xml(name = "header")
data class Header(
    @PropertyElement
    val resultCode: String ?= null,
    @PropertyElement
    val resultMsg: String ?= null
)

@Xml(name = "body")
data class Body(
    @Element
    val items: Items ?= null,
    @PropertyElement
    val numOfRows: String ?= null,
    @PropertyElement
    val pageNo: String ?= null,
    @PropertyElement
    val totalCount: String ?= null,
)

@Xml
data class Items(
    @Element(name = "item")
    val item: List<Item> ?= null,
)
@Xml(name = "item")
data class Item(
    @PropertyElement(name = "거래금액") val DealAmount: String? = null,
    @PropertyElement(name = "건축년도") val BuildYear: String? = null,
    @PropertyElement(name = "년") val DealYear: String? = null,
    @PropertyElement(name = "법정동") val Dong: String? = null,
    @PropertyElement(name = "아파트") val ApartmentName: String? = null,
    @PropertyElement(name = "월") val DealMonth: String? = null,
    @PropertyElement(name = "일") val DealDay: String? = null,
    @PropertyElement(name = "전용면적") val AreaForExclusiveUse: String? = null,
    @PropertyElement(name = "지번") val Jibun: String? = null,
    @PropertyElement(name = "지역코드") val RegionalCode: String? = null,
    @PropertyElement(name = "층") val Floor: String? = null,
    @PropertyElement(name = "해제사유발생일") val CancelDealType: String? = null,
    @PropertyElement(name = "해제여부") val CancelDealDay: String? = null,
    //@PropertyElement(name = "") val REQGBN: String?,
    //PropertyElement(name = "") val RdealerLawdnm: String?
)

