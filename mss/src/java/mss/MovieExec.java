/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mss;

/**
 *
 * @author bnp26
 */
public class MovieExec {
    
    private String name;
    private int cert;
    private String address;
    private float networth;
    
    public MovieExec() {
    }

    public MovieExec(String name) {
        this.name = name;
    }

    public MovieExec(String name, int cert, String address, float networth) {
        this.name = name;
        this.cert = cert;
        this.address = address;
        this.networth = networth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCert() {
        return cert;
    }

    public void setCert(int cert) {
        this.cert = cert;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getNetworth() {
        return networth;
    }

    public void setNetworth(float networth) {
        this.networth = networth;
    }
}
