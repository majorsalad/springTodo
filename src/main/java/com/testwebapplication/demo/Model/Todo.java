package com.testwebapplication.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Todo
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String user;
	@Size(min = 6, message = "Description must be at least 6 characters")
	private String desc;
	private boolean isDone;

	protected Todo()
	{
	}

	public Todo(String user, String desc, boolean isDone)
	{
		super();
		this.user = user;
		this.desc = desc;
		this.isDone = isDone;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public boolean isDone()
	{
		return isDone;
	}

	public void setDone(boolean isDone)
	{
		this.isDone = isDone;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if ( this == obj )
		{
			return true;
		}
		if ( obj == null )
		{
			return false;
		}
		if ( getClass() != obj.getClass() )
		{
			return false;
		}
		Todo other = (Todo) obj;
		if ( id != other.id )
		{
			return false;
		}
		return true;
	}

	//    @Override
	//    public String toString() {
	//        return String.format(
	//                "Todo [id=%s, user=%s, desc=%s, targetDate=%s, isDone=%s]", id,
	//                user, desc, targetDate, isDone);
	//    }

}
