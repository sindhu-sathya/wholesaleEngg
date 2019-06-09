/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.exception;
/**
 * 
 * Custom Exception file.
 *
 */
public class DataNotFoundException extends RuntimeException
{
   private static final long serialVersionUID = -3439345267498821751L;

   public DataNotFoundException(final String message)
   {
      super(message);
   }

   public DataNotFoundException(final String message, final Throwable cause)
   {
      super(message, cause);
   }
}
