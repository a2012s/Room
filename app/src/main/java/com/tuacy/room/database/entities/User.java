package com.tuacy.room.database.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 数据库中的表。
 * Room 将类名称用作数据库表名称。如果您希望表具有不同的名称，请设置 @Entity 注释的 tableName 属性，如以下代码段所示：@Entity(tableName = "user")
 * 注意：SQLite 中的表名称不区分大小写。
 */
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private long uid;
    private String name;
    private String address;
    private String phone;
    private Integer age;

    @ColumnInfo(name = "first_name")//与 tableName 属性类似，Room 将字段名称用作数据库中的列名称。如果您希望列具有不同的名称，请将 @ColumnInfo 注释添加到字段
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "uid=" + uid + ", name='" + name + '\'' + ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", age=" +
                age + '}';
    }
}
