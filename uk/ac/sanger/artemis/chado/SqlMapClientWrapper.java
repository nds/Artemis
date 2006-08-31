/* SqlMapClientWrapper                                                                                                 /* IBatisDAO
 *
 * created: 2006
 *
 * This file is part of Artemis
 *
 * Copyright (C) 2005  Genome Research Limited
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 */

package uk.ac.sanger.artemis.chado;

import javax.swing.JPasswordField;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Wrapper for com.ibatis.sqlmap.client.SqlMapClient, so that
 * RuntimeExceptions are thrown rather than SQLExceptions.
 */
public class SqlMapClientWrapper 
{
  
  private SqlMapClient sqlMap;
  
  public SqlMapClientWrapper(final JPasswordField pfield)
  {
    DbSqlConfig sql_config = new DbSqlConfig();
    sql_config.init(pfield);
    this.sqlMap = sql_config.getSqlMapInstance();
  }
  
  
  public List queryForList(final String method, final Object arg)
  {
    try
    {
      return sqlMap.queryForList(method, arg);
    }
    catch(SQLException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public Object queryForObject(final String method, final Object arg)
  {
    try
    {
      return sqlMap.queryForObject(method, arg);
    }
    catch(SQLException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public Object insert(final String method, final Object arg)
  {
    try
    {
      return sqlMap.insert(method, arg);
    }
    catch(SQLException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public int delete(final String method, final Object arg)
  {
    try
    {
      return sqlMap.delete(method, arg);
    }
    catch(SQLException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public int update(final String method, final Object arg)
  {
    try
    {
      return sqlMap.update(method, arg);
    }
    catch(SQLException e)
    {
      throw new RuntimeException(e);
    }
  }

  public void startTransaction() throws SQLException
  { 
    sqlMap.startTransaction();
  }
  
  public void endTransaction() throws SQLException
  { 
    sqlMap.endTransaction();
  }
  
  public void commitTransaction() throws SQLException
  {
    sqlMap.commitTransaction();
  }

  public SqlMapClient getSqlMap()
  {
    return sqlMap;
  }
}