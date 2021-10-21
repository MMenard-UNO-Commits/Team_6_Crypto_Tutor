package com.searchEngine;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcraft.jsch.*;

public class ApiServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String username = "mmenard";
    private static final String password = "CryptoCap1234";
    private static final String host = "104.131.172.9";
    private static final int port = 22;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String input1 = "\"" + request.getParameter("code") + "\"";
        String inputCommand1 = "echo " + input1 + ">tempComp/thing1.java";
        String input2 = "\"public void execute() {\n" + "    super.execute();\n"
                + "     UndoManager um = getDrawingEditor().getUndoManager();\n"
                + "     if ((um == null) || !um.isRedoable()) {\n" + "        return;\n" + "}\n" + "\n"
                + "     Undoable lastRedoable = um.popRedo();\n" + "    // Execute redo \n"
                + "     boolean hasBeenUndone = lastRedoable.redo();\n" + "  // Add to undo stack\n"
                + "     if (hasBeenUndone && lastRedoable.isUndoable()) {\n" + "\n" + "        um.pushUndo(lastRedoable);\n"
                + "}\n" + "\n" + "     lastRedoable.getDrawingView().checkDamage();\n" + "\n"
                + "     getDrawingEditor().figureSelectionChanged(lastRedoable.getDrawingView());\n" + "}\n\"";
        String inputCommand2 = "echo " + input2 + ">tempComp/thing2.java";
        String command1 = "./traverse";
        String command2 = "./readClone";
        String command3 = "./readDiff";
        System.out.println(inputCommand1);

        try {
            runUnixCommandOnServer(username, password, host, port, inputCommand1);
            runUnixCommandOnServer(username, password, host, port, inputCommand2);

            runUnixCommandOnServer(username, password, host, port, command1);
            String clones = runUnixCommandOnServer(username, password, host, port, command2);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print(clones);
            String diffs = runUnixCommandOnServer(username, password, host, port, command3);
            out.print(diffs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String runUnixCommandOnServer(String username, String password, String host, int port, String command)
            throws Exception {
        Session session = null;
        ChannelExec channel = null;

        try {
            session = new JSch().getSession(username, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            // System.out.println("Connected!");

            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.connect();
            System.out.println("Command Sent!");

            while (channel.isConnected()) {
                Thread.sleep(10);
            }

            String responseString = new String(responseStream.toByteArray());
            System.out.println(responseString);
            return responseString;

        } finally {
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
        }
    }
}
