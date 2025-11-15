# Chaikin's Algorithm Animation

## Project Overview
The goal of this project is to implement **Chaikin's algorithm** and create a **step-by-step animation** of the process using a canvas.

---

## Task 1 – Canvas & Control Points Input
**Objective:** Create the basic interface for drawing points.

**Description:**
- Create a window/canvas where the user can draw points.
- Each point should be represented by a small circle.
- Capture mouse clicks to place control points using the left button.
- Display each point immediately on the canvas after placement.

**Deliverables:**
- Functional window/canvas
- Mouse input handling to add points
- Points displayed in real-time on the canvas

---

## Task 2 – Special Cases Handling
**Objective:** Handle special conditions before animating Chaikin.

**Description:**
- If no points are drawn → do nothing when pressing Enter.
- If only one point → display only that point.
- If two points → draw a straight line between the two points.
- Handle closing the window using the Escape key.

**Deliverables:**
- Correct behavior according to the number of points
- Window closes properly with Escape key

---

## Task 3 – Chaikin Animation
**Objective:** Implement and animate Chaikin's algorithm.

**Description:**
- Implement Chaikin's algorithm to generate new curves.
- Start the animation when pressing Enter.
- Cycle through steps up to the 7th iteration, then restart.
- The animation should display the steps **progressively**, in real-time.

**Deliverables:**
- Functional Chaikin algorithm
- Step-by-step animation up to the 7th iteration
- Continuous looping after the 7th step

---

## Task 4 – Bonus Features (Optional)
**Objective:** Improve interactivity and user experience.

**Description:**
- Add the ability to **clear/reset the canvas** to draw new points.
- Allow **drag-and-drop** of existing points for real-time adjustment.
- Optionally, display messages to guide the user if no points are drawn.

**Deliverables:**
- Resettable canvas
- Interactive points that can be moved in real-time
- Improved UI for guidance messages
