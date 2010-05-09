//$Id: IncomingAddressData.java,v 1.1.1.1 2006/10/02 15:21:13 guy Exp $
//$Log: IncomingAddressData.java,v $
//Revision 1.1.1.1  2006/10/02 15:21:13  guy
//Import into CVS.
//
//Revision 1.1.1.1  2006/04/29 08:55:46  guy
//Initial import.
//
//Revision 1.1.1.1  2006/03/29 13:21:31  guy
//Imported.
//
//Revision 1.1.1.1  2006/03/23 16:25:28  guy
//Imported.
//
//Revision 1.1.1.1  2006/03/22 13:46:54  guy
//Import.
//
//Revision 1.2  2006/03/15 10:31:59  guy
//Formatted code.
//
//Revision 1.1.1.1  2006/03/09 14:59:13  guy
//Imported 3.0 development into CVS repository.
//
//Revision 1.3  2005/11/11 10:52:03  guy
//Added Externalizable to save address headers in XML format
//(avoids serialization problems in writing PREPARED log entry)
//
//Revision 1.2  2005/11/01 09:11:41  guy
//Corrected with WSAT test feedback.
//
//Revision 1.1  2005/10/18 12:41:01  guy
//Added addressing logic.
//
package com.atomikos.icatch.jaxb.wsa;

import java.io.Serializable;

/**
 * 
 * Copyright &copy; 2005, Atomikos. All rights reserved.
 * 
 * 
 * Defines access for incoming addressing data (mainly reference properties), 
 * and allows easy conversion into reply address data. 
 * This class also minimizes application dependencies on versions of WSA. 
 * 
 * <b>The existence of configured and version-specific WSA handlers is necessary
 * for this design to work correctly.</b>
 * 
 */
public abstract class IncomingAddressingHeaders implements Serializable
{


    protected String target;

    protected String messageId;


    protected IncomingAddressingHeaders ()
    {
    }

    protected void setMessageId ( String msgId ) 
    {
    	this.messageId = msgId;
    }
    
    protected void setTarget ( String target ) 
    {
    	this.target = target;
    }

    /**
     * Gets the target URI as contained in the reference properties of the
     * addressing headers.
     * 
     * @return The URI, or null if not found.
     */
    public String getTarget ()
    {
        return this.target;
    }
    
    /**
     * Gets the messageID if any.
     * 
     * @return
     */
    public String getMessageId() 
    {
    	return this.messageId;
    }

    /**
     * Creates a reply address according to the reply parameters in the incoming
     * addressing data.
     * 
     * @return The reply address, or null if no reply headers were present. The
     *         result will automatically have the to, reference properties, and
     *         the relatesTo headers set appropriately.
     */
    public abstract OutgoingAddressingHeaders createReplyAddress ();

    /**
     * Creates a fault address according to the fault/reply parameters in the
     * incoming addressing data.
     * 
     * @return The address, or null if not applicable. The result will
     *         automatically have the to, reference properties, and the
     *         relatesTo headers set appropriately.
     */
    public abstract OutgoingAddressingHeaders createFaultAddress ();

}
