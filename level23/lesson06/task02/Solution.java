package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public final static class Constants
    {
        private static final String SERVER_NOT_ACCESSIBLE_NOW = "Server is not accessible for now.";
        private static final String  UNAUTRHORIZED_UZVER = "User is not authorized.";
        private static final String BANNED_UZVER = "User is banned.";
        private static final String RESTRICTION = "Access is denied.";

        public class ServerNotAccessibleException extends Exception
        {
            public ServerNotAccessibleException()
            {
                super(Constants.SERVER_NOT_ACCESSIBLE_NOW);
            }

            public ServerNotAccessibleException(Throwable cause)
            {
                super(Constants.SERVER_NOT_ACCESSIBLE_NOW, cause);
            }
        }

        public class UnauthorizedUserException extends Exception
        {
            public UnauthorizedUserException()
            {
                super(Constants.UNAUTRHORIZED_UZVER);
            }

            public UnauthorizedUserException(Throwable cause)
            {
                super(Constants.UNAUTRHORIZED_UZVER, cause);
            }
        }

        public class BannedUserException extends Exception
        {
            public BannedUserException()
            {
                super(Constants.BANNED_UZVER);
            }

            public BannedUserException(Throwable cause)
            {
                super(Constants.BANNED_UZVER, cause);
            }
        }

        public class RestrictionException extends Exception
        {
            public RestrictionException()
            {
                super(Constants.RESTRICTION);
            }

            public RestrictionException(Throwable cause)
            {
                super(Constants.RESTRICTION, cause);
            }
        }
    }
}
