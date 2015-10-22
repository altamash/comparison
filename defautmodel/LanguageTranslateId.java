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
 * <p>Title: LanguageTranslateId</p>
 *
 * <p>Description: Embedded Id describing a LanguageTranslateId entity primary key</p>
 *
 */
@Embeddable
public class LanguageTranslateId implements Serializable {


    @Column(name="iso6392t" ,length=3 ,nullable=false)
    private String iso6392t;

    @Column(name="for_iso6392t" ,length=3 ,nullable=false)
    private String forIso6392t;

	public String getIso6392t() {
        return iso6392t;
    }
	
    public void setIso6392t (String iso6392t) {
        this.iso6392t = iso6392t;
    }

	public String getForIso6392t() {
        return forIso6392t;
    }
	
    public void setForIso6392t (String forIso6392t) {
        this.forIso6392t = forIso6392t;
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
        return "LanguageTranslateId:" 
        + ":" + forIso6392t
        ;
    }
    
}
