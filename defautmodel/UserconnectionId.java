/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9
	* - name      : DomainEntityJPA2EmbeddedId
	* - file name : DomainEntityJPA2EmbeddedId.vm
*/
package defaultroot.defautmodel.domain.defautmodel;

import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

/**
 *
 * <p>Title: UserconnectionId</p>
 *
 * <p>Description: Embedded Id describing a UserconnectionId entity primary key</p>
 *
 */
@Embeddable
public class UserconnectionId implements Serializable {


    @Column(name="userId" ,length=255 ,nullable=false)
    private String userid;

    @Column(name="providerId" ,length=255 ,nullable=false)
    private String providerid;

    @Column(name="providerUserId" ,length=255 ,nullable=false)
    private String provideruserid;

	public String getUserid() {
        return userid;
    }
	
    public void setUserid (String userid) {
        this.userid = userid;
    }

	public String getProviderid() {
        return providerid;
    }
	
    public void setProviderid (String providerid) {
        this.providerid = providerid;
    }

	public String getProvideruserid() {
        return provideruserid;
    }
	
    public void setProvideruserid (String provideruserid) {
        this.provideruserid = provideruserid;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return obj.toString().equals(this.toString());
    }
 
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
 
    @Override
    public String toString() {
        return "UserconnectionId:" 
        + ":" + userid
        + ":" + providerid
        + ":" + provideruserid
        ;
    }
    
}
