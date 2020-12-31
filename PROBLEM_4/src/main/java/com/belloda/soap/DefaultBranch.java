package com.belloda.soap;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "BranchOffice")
public class DefaultBranch implements BranchOffice {

String name;
String address;

public DefaultBranch(){

}
public DefaultBranch(String name, String address) {
    this.name = name;
    this.address = address;
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


    


}
