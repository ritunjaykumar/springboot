package com.softgyan.springboot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;

    private String _name;

    private String _city;

    private String _status;

    public User() {
    }

    public User(User userTemp){
        this(userTemp.get_id(), userTemp.get_name(), userTemp.get_city(), userTemp.get_status());
    }

    public User(int _id, String _name, String _city, String _status) {
        this._id = _id;
        this._name = _name;
        this._city = _city;
        this._status = _status;
    }
    public User(String _name, String _city, String _status) {
        this(-1,_name,_city,_status);
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String get_status() {
        return _status;
    }

    public void set_status(String _status) {
        this._status = _status;
    }


    public User updateUser(User user){
        this._id = user.get_id();;
        this._name = user.get_name();
        this._city = user.get_city();
        this._status = user.get_status();

        return this;
    }

    /*@Override
    public String toString() {
        return "User{" +
                "\n_id=" + _id +
                "\n_name='" + _name + '\'' +
                "\n_city='" + _city + '\'' +
                "\n_status='" + _status + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", _name='" + _name + '\'' +
                ", _city='" + _city + '\'' +
                ", _status='" + _status + '\'' +
                '}';
    }
}
