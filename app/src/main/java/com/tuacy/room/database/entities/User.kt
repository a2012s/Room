package com.tuacy.room.database.entities

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    var uid: Long,
    @ColumnInfo(name = "name")
    var name: String?,
    @ColumnInfo(name = "address")
    var address: String?,
    @ColumnInfo(name = "phone")
    var phone: String?,
    @ColumnInfo(name = "age")
    var age: Int,
    @Ignore //禁止将字段映射到数据表。数据库不创建这个字段
    var picture: Bitmap?
) {
    //必须构造一个函数
    constructor() : this(0, "", "UNKNOWN", "", 0, null)

}
