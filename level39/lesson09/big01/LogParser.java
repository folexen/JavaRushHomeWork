package com.javarush.test.level39.lesson09.big01;
import com.javarush.test.level39.lesson09.big01.query.IPQuery;
import com.javarush.test.level39.lesson09.big01.query.UserQuery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class LogParser implements IPQuery, UserQuery
{
    Path logDir;
    List<LogEntry> logEntries = new ArrayList<>();
    class LogEntry
    {
        String ip;
        String username;
        Date date;
        String event;
        String status;

        public LogEntry(String ip, String username, Date date, String event, String status)
        {
            this.date = date;
            this.event = event;
            this.ip = ip;
            this.status = status;
            this.username = username;
        }

        public Date getDate()
        {
            return date;
        }

        public void setDate(Date date)
        {
            this.date = date;
        }

        public String getEvent()
        {
            return event;
        }

        public void setEvent(String event)
        {
            this.event = event;
        }

        public String getIp()
        {
            return ip;
        }

        public void setIp(String ip)
        {
            this.ip = ip;
        }

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }

        public String getUsername()
        {
            return username;
        }

        public void setUsername(String username)
        {
            this.username = username;
        }
    }

    public LogParser(Path logDir)
    {
        this.logDir = logDir;
        File logFolder = new File(logDir.toString());
        File[] logFileList = logFolder.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        for (int i = 0; i < logFileList.length; i++)
        {
            if (logFileList[i].isFile() && logFileList[i].toString().endsWith(".log"))
            {
                try (BufferedReader br = new BufferedReader(new FileReader(logFileList[i]));)
                {
                    String s = null;
                    while ((s = br.readLine()) != null)
                    {
                        LogEntry logEntry = null;
                        String[] logString = s.split("\t");
                        String ip = logString[0];
                        String user = logString[1];
                        String dateString = logString[2];
                        Date date = null;
                        try
                        {
                            date = sdf.parse(dateString);
                        }
                        catch (ParseException e)
                        {
                            e.printStackTrace();
                        }
                        String eventString = logString[3];
                        String statusString = logString[4];
                        logEntries.add(new LogEntry(ip,user,date,eventString,statusString));
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addIPs(Set<String> ipSet, LogEntry logEntry, Date after, Date before)
    {
        if (after == null && before == null)
        {
            ipSet.add(logEntry.getIp());
        } else if (after == null && before != null)
        {
            if (logEntry.getDate().before(before) || logEntry.getDate().equals(before))
                ipSet.add(logEntry.getIp());
        } else if (after != null && before == null)
        {
            if (logEntry.getDate().after(after) || logEntry.getDate().equals(after))
                ipSet.add(logEntry.getIp());
        } else
        {
            if (logEntry.getDate().after(after) && logEntry.getDate().before(before) || logEntry.getDate().equals(after) || logEntry.getDate().equals(before))
                ipSet.add(logEntry.getIp());
        }
    }
    public void addUsers(Set<String> userSet, LogEntry logEntry, Date after, Date before)
    {
        if (after == null && before == null)
        {
            userSet.add(logEntry.getUsername());
        } else if (after == null && before != null)
        {
            if (logEntry.getDate().before(before) || logEntry.getDate().equals(before))
                userSet.add(logEntry.getUsername());
        } else if (after != null && before == null)
        {
            if (logEntry.getDate().after(after) || logEntry.getDate().equals(after))
                userSet.add(logEntry.getUsername());
        } else
        {
            if (logEntry.getDate().after(after) && logEntry.getDate().before(before) || logEntry.getDate().equals(after) || logEntry.getDate().equals(before))
                userSet.add(logEntry.getUsername());
        }
    }
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before)
    {
        return getUniqueIPs(after, before).size();
    }
    @Override
    public Set<String> getUniqueIPs(Date after, Date before)
    {
        Set<String> uniqueIPsSet = new HashSet<>();
        for (LogEntry logEntry : logEntries)
        {
            addIPs(uniqueIPsSet, logEntry, after, before);
        }
        return uniqueIPsSet;
    }
    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before)
    {
        if (event == null) return null;
        Set<String> uniqueIPsForEventSet = new HashSet<>();
        for (LogEntry logEntry : logEntries)
        {
            if (!logEntry.getEvent().contains(event.toString())) continue;
            addIPs(uniqueIPsForEventSet, logEntry, after, before);
        }
        return uniqueIPsForEventSet;
    }
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before)
    {
        if (user == null) return null;
        Set<String> uniqueIPsForUserSet = new HashSet<>();
        for (LogEntry logEntry : logEntries)
        {
            if (!logEntry.getUsername().contains(user)) continue;
            addIPs(uniqueIPsForUserSet, logEntry, after, before);
        }
        return uniqueIPsForUserSet;
    }
    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before)
    {
        if (status == null) return null;
        Set<String> uniqueIPsForStatusSet = new HashSet<>();
        for (LogEntry logEntry : logEntries)
        {
            if (!logEntry.getStatus().contains(status.toString())) continue;
            addIPs(uniqueIPsForStatusSet, logEntry, after, before);
        }
        return uniqueIPsForStatusSet;
    }

    @Override
    public Set<String> getAllUsers()
    {
        Set<String> allUsersSet = new HashSet<>();
        for (LogEntry logEntry: logEntries)
        {
            allUsersSet.add(logEntry.getUsername());
        }
        return allUsersSet;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before)
    {
        Set<String> usersNumber = new HashSet<>();
        for (LogEntry logEntry: logEntries)
        {
            addUsers(usersNumber, logEntry, after, before);
        }
        return usersNumber.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before)
    {
        if (user == null) return 0;
        Set<String> numberOfUserEvents = new HashSet<>();
        for (LogEntry logEntry: logEntries)
        {
            if (!logEntry.getUsername().contains(user)) continue;
            addUsers(numberOfUserEvents, logEntry, after, before);
        }
        return numberOfUserEvents.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before)
    {
        if(ip == null) return null;
        Set<String> usersForIP = new HashSet<>();
        for(LogEntry logEntry: logEntries)
        {
            if (!logEntry.getIp().contains(ip)) continue;
            addUsers(usersForIP, logEntry, after, before);

        }
        return usersForIP;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before)
    {
        Set<String> loggedUsers = new HashSet<>();
        for (LogEntry logEntry: logEntries)
        {
            if (!logEntry.getEvent().contains(Event.LOGIN.toString()) &&
                    !logEntry.getStatus().contains(Status.OK.toString())) continue;
            addUsers(loggedUsers, logEntry, after, before);

        }
        return loggedUsers;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before)
    {
        Set<String> downloadedPluginUsers = new HashSet<>();
        for (LogEntry logEntry: logEntries)
        {
            if (!logEntry.getEvent().contains(Event.DOWNLOAD_PLUGIN.toString()) &&
                    !logEntry.getStatus().contains(Status.OK.toString())) continue;
            addUsers(downloadedPluginUsers, logEntry, after, before);
        }
        return downloadedPluginUsers;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before)
    {
        Set<String> wroteMessageUsers = new HashSet<>();
        for (LogEntry logEntry: logEntries)
        {
            if (!logEntry.getEvent().contains(Event.WRITE_MESSAGE.toString()) &&
                    !logEntry.getStatus().contains(Status.OK.toString())) continue;
            addUsers(wroteMessageUsers, logEntry, after, before);
        }
        return wroteMessageUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before)
    {
        Set<String> solvedTaskUsers = new HashSet<>();
        for (LogEntry logEntry: logEntries)
        {
            if (!logEntry.getEvent().contains(Event.SOLVE_TASK.toString()) &&
                    !logEntry.getStatus().contains(Status.OK.toString())) continue;;
            addUsers(solvedTaskUsers, logEntry, after, before);
        }
        return solvedTaskUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task)
    {
        if (task == 0) return null;
        Set<String> solvedTaskUsersNumber = new HashSet<>();
        for (LogEntry logEntry: logEntries)
        {
            if (!logEntry.getEvent().contains(Event.SOLVE_TASK.toString()) &&
                    !logEntry.getStatus().contains(Status.OK.toString())) continue;
            else if (!(Integer.parseInt(logEntry.getEvent().split(" ")[1]) == task)) continue;
            addUsers(solvedTaskUsersNumber, logEntry, after, before);
        }
        return solvedTaskUsersNumber;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before)
    {
        Set<String> doneTaskUsers = new HashSet<>();
        for (LogEntry logEntry: logEntries)
        {
            if (!logEntry.getEvent().contains(Event.DONE_TASK.toString()) &&
                    !logEntry.getStatus().contains(Status.OK.toString())) continue;
            addUsers(doneTaskUsers, logEntry, after, before);
        }
        return doneTaskUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task)
    {
        if (task == 0) return null;
        Set<String> doneTaskUsersNumber = new HashSet<>();
        for (LogEntry logEntry: logEntries)
        {
            if (!logEntry.getEvent().contains(Event.DONE_TASK.toString()) &&
                    !logEntry.getStatus().contains(Status.OK.toString())) continue;
            else if (!(Integer.parseInt(logEntry.getEvent().split(" ")[1]) == task)) continue;
            addUsers(doneTaskUsersNumber, logEntry, after, before);
        }
        return doneTaskUsersNumber;
    }
}