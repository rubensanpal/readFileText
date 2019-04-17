package com.sanpal.read;

public interface ReadSourceRemote {
    /**
     * Method for read file, without modifications
     * @return macro whit script for PDMS
     * @author Ruben sanpal
     */
    String buildMacro (String path);

    /**
     * Method for read file and to make modifications from user,
     * password and macro name.
     * @param user from client
     * @param pass from client
     * @param nameMacro name macro temp build
     * @return file bat type with change
     * @author Ruben Sanpal
     */
    String changeBatParameters (String path, String user, String pass,String nameMacro);

    /**
     *
     * @return file in String format
     */
    String readText (String path);

}
