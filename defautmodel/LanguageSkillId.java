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
	* - time      : 2015/08/04 AD at 17:45:44 PKT
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
 * <p>Title: LanguageSkillId</p>
 *
 * <p>Description: Embedded Id describing a LanguageSkillId entity primary key</p>
 *
 */
@Embeddable
public class LanguageSkillId implements Serializable {


    @Column(name="user_id"  ,nullable=false)
    private Integer userId;

    @Column(name="iso6392t" ,length=3 ,nullable=false)
    private String iso6392t;

	public Integer getUserId() {
        return userId;
    }
	
    public void setUserId (Integer userId) {
        this.userId = userId;
    }

	public String getIso6392t() {
        return iso6392t;
    }
	
    public void setIso6392t (String iso6392t) {
        this.iso6392t = iso6392t;
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
        return "LanguageSkillId:" 
        + ":" + iso6392t
        ;
    }
    
}
