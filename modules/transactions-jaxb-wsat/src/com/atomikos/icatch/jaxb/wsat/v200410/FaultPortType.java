
package com.atomikos.icatch.jaxb.wsat.v200410;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * This class was generated by the CXF 2.0-incubator
 * Wed Jul 11 17:41:04 CEST 2007
 * Generated source version: 2.0-incubator
 * 
 */

@WebService(targetNamespace = "http://schemas.xmlsoap.org/ws/2004/10/wsat", name = "FaultPortType")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

public interface FaultPortType {

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Oneway
    @WebMethod(operationName = "FaultOperation")
    public void faultOperation(
        @WebParam(targetNamespace = "http://schemas.xmlsoap.org/soap/envelope/", partName = "content", name = "Fault")
        com.atomikos.icatch.jaxb.wsat.v200410.Fault content
    );
}
