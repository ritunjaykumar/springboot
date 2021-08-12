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
        this(userTemp.getId(), userTemp.getName(), userTemp.getCity(), userTemp.getStatus());
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

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String _city) {
        this._city = _city;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String _status) {
        this._status = _status;
    }


    public User updateUser(User user){
        this._id = user.getId();;
        this._name = user.getName();
        this._city = user.getCity();
        this._status = user.getStatus();

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
