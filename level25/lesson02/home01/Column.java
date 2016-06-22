package com.javarush.test.level25.lesson02.home01;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable
{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");


    private String columnName;

    private static int[] realOrder;

    private Column(String columnName)
    {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder)
    {
        realOrder = new int[values().length];
        for (Column column : values())
        {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++)
            {
                if (column == newOrder[i])
                {
                    if (isFound)
                    {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns()
    {
        List<Column> result = new LinkedList<>();
        Column[] columns = Column.values();
        for (int a = 0; a < realOrder.length; a++)
        {
            if (columns[a].isShown())
            {
                result.add(columns[a]);
            }
        }
        for (int a = 0; a < realOrder.length; a++)
        {
            if (columns[a].isShown())
            {
                result.set(realOrder[a], columns[a]);
            }
        }

        return result;
    }


    /**
     * @return полное имя колонки
     */
    @Override
    public String getColumnName()
    {
        return columnName;
    }

    /**
     * Возвращает true, если колонка видимая, иначе false
     */
    @Override
    public boolean isShown()
    {
        if (realOrder[this.ordinal()] != -1) return true;
        else return false;
    }

    /**
     * Скрывает колонку - маркирует колонку -1 в массиве realOrder.
     * Сдвигает индексы отображаемых колонок, которые идут после скрытой
     */
    @Override
    public void hide()
    {
        int nul = realOrder[Column.this.ordinal()];
        if (realOrder[Column.this.ordinal()] != -1)
        {
            realOrder[Column.this.ordinal()] = -1;
            for (int a = 0; a < realOrder.length; a++)
            {
                if (realOrder[a] > nul)
                {
                    realOrder[a]--;
                }
            }
        }
    }
}