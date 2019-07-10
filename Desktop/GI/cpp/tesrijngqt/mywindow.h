#ifndef MYWINDOW_H
#define MYWINDOW_H

#include <QWidget>
#include<QApplication>
#include<QPushButton>
#include<QLCDNumber>
#include<QSlider>
#include<QProgressBar>

class MyWindow : public QWidget
{
    Q_OBJECT
    public:
        MyWindow();
    public slots:
        void changeWidth(int w);
        void changeHeight(int h);
    signals:
        void maxWidthOrHeight();

    private:
        //QPushButton *button;
        //QLCDNumber *myLcd;
        //QProgressBar *myBar;
        QSlider *mySlider,*slider;
};

#endif // MYWINDOW_H
