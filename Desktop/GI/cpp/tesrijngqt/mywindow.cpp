#include "mywindow.h"

MyWindow::MyWindow() : QWidget ()
{
    setFixedSize(200,100);
    /*button = new QPushButton("Reset",this);
    button->setFont(QFont("Comic SANS Ms",16));
    button->setCursor(Qt::PointingHandCursor);
    button->move(80,85);
    myLcd = new QLCDNumber(this);
    myLcd->setSegmentStyle(QLCDNumber::Flat);
    myLcd->move(50,20);
    myBar = new QProgressBar(this);
    myBar->setGeometry(10,10,150,20);
    mySlider = new QSlider(Qt::Horizontal,this);
    mySlider->setGeometry(10,60,150,20);
    QObject::connect(mySlider,SIGNAL(valueChanged(int)),myBar,SLOT(setValue(int)));
    QObject::connect(button,SIGNAL(clicked()),myBar,SLOT(reset()));*/
    mySlider = new QSlider(Qt::Horizontal,this);
    slider = new QSlider(Qt::Vertical,this);
    mySlider->setRange(200,600);
    mySlider->setGeometry(10,60,150,20);
    slider->setRange(200,600);
    slider->setGeometry(160,30,30,60);
    QObject::connect(mySlider,SIGNAL(valueChanged(int)),this,SLOT(changeWidth(int)));
    //QObject::connect(slider,SIGNAL(valueChanged(int)),this,SLOT(changeHeight(int)));
    QObject::connect(slider,SIGNAL(valueChanged(int)),this,SLOT(changeHeight(int)));
    QObject::connect(this,SIGNAL(maxWidthOrHeight()),qApp,SLOT(quit()));

}
void MyWindow::changeWidth(int w){
    setFixedSize(w,height());
}
void MyWindow::changeHeight(int h){
    setFixedSize(width(),h);
    if (h==600){
        emit maxWidthOrHeight();
    }
}

