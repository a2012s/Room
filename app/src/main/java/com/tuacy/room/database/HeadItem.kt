package com.tuacy.room.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
class HeadItem {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo(name = "name")
    var name: String? = ""

    @ColumnInfo(name = "childStartIndex")
    var childStartIndex: Int = 0

    @ColumnInfo(name = "childEndIndex")
    var childEndIndex: Int = 0

    @ColumnInfo(name = "allCheck")
    var allCheck: Boolean = false

    @ColumnInfo(name = "days")
    var days: String = ""

    @ColumnInfo(name = "times")
    var times: Long = 0

    /**
     * Room会使用这个构造器来存储数据，也就是当你从表中得到Student对象时候，Room会使用这个构造器
     */

    constructor(
        id: Long,
        name: String,
        childStartIndex: Int,
        childEndIndex: Int,
        allCheck: Boolean,
        days: String,
        times: Long
    ) {
        this.id = id
        this.name = name
        this.childStartIndex = childStartIndex
        this.childEndIndex = childEndIndex
        this.allCheck = allCheck
        this.days = days
        this.times = times
    }

    /**
     * 由于Room只能识别和使用一个构造器，如果希望定义多个构造器，你可以使用Ignore标签，让Room忽略这个构造器
     * 同样，@Ignore标签还可用于字段，使用@Ignore标签标记过的字段，Room不会持久化该字段的数据
     */
    @Ignore
    constructor(
        name: String,
        childStartIndex: Int,
        childEndIndex: Int,
        allCheck: Boolean,
        days: String,
        times: Long
    ) {
        this.name = name
        this.childStartIndex = childStartIndex
        this.childEndIndex = childEndIndex
        this.allCheck = allCheck
        this.days = days
        this.times = times
    }

    @Ignore
    constructor(id: Long, name: String) {
        this.name = name
        this.id = id
    }

    @Ignore
    constructor(id: Long) {
        this.id = id
    }



}