import cv2
import numpy as np
from networktables import NetworkTables

#green = [36, 202, 59, 71, 255, 255]
#yellow = [18, 0, 196, 36, 255, 255]

# These are inverted colors of red and blue (see line 34)
blue = [5, 50, 20, 25, 255, 255]
red = [80, 50, 20, 100, 255, 255]

#Set the color
color = blue

# Initialize Video Feed(s)
cap1 = cv2.VideoCapture('http://192.168.1.196:8080/?action=stream')
cap2 = cv2.VideoCapture('Videos/b.mp4')
cap3 = cv2.VideoCapture('Videos/c.mp4')

# Connect to the robot
NetworkTables.initialize(server="roborio-5057-frc.local")
sd = NetworkTables.getTable('SmartDashboard')
print("Is connected: " + str(NetworkTables.isConnected()))

while(True):
    # Take each frame
    _, frame1 = cap1.read()
    _, frame2 = cap2.read()
    _, frame3 = cap3.read()
    
    stacked = np.hstack((frame1,frame1))

    # Invert the image so that red can be more accurate
    stacked_inv = -stacked
    frameHSV = cv2.cvtColor(stacked_inv, cv2.COLOR_BGR2HSV)
    
    # HSV values to define a colour range we want to create a mask from.
    colorLow = np.array(color[0:3])
    colorHigh = np.array(color[3:6])
    mask = cv2.inRange(frameHSV, colorLow, colorHigh)

    #cv2.imshow("mask", mask)

    # Get the countours of the all that is in the color range
    contours, h = cv2.findContours(mask, 1, 2)
    contours = sorted(contours, key = cv2.contourArea, reverse = True)[:]

    for cnt in contours:
        # For every contour, create a circle around it
        ((x, y), radius) = cv2.minEnclosingCircle(cnt)

        # Only proceed if the radius meets a minimum size
        # and if the area of the contour is atleast 75% of the enclosing circle
        if radius > 10 and cv2.contourArea(cnt)/(np.pi*radius**2) > 0.75:
            cv2.drawContours(stacked, cnt, -1, (0,255,0), 3 )

            middleX = int(x)
            middleY = int(y)
            percentX = (middleX / stacked.shape[0])
            percentY = (middleY / stacked.shape[1])

            sd.putNumber("Ball X position:", middleX)
            sd.putNumber("Ball Y position:", middleY)

            # draw the circle and centroid on the frame
            cv2.circle(stacked, (middleX,middleY), int(radius),(0, 0, 255), 2)
            cv2.circle(stacked, (middleX,middleY), 5, (0, 0, 255), -1)

    # Show final output image
    cv2.imshow('Result', stacked)
    
    if cv2.waitKey(1) & 0xFF==ord('q'):
        break

    
cv2.destroyAllWindows()
cap1.release()
cap2.release()
cap3.release()