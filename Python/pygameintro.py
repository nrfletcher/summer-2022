import pygame
import sys
from pygame.locals import *

GAME_DEFINER = "block_"
LOGIC_DEFINER = "trn_"


def draw(surf):
    surf.blit()


class Building(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.rect = Rect(50, 50, 25, 25)
        self.rect.center = (250, 250)


pygame.init()  # Essential part of a pyGame program
pygame.display.set_caption('My game')
FPS = pygame.time.Clock()  # How we can control our game FPS, otherwise Python will execute as many as it can

screen = pygame.display.set_mode((500, 500))  # Setting up our game screen
background = pygame.Surface((500, 500))  # A surface we can use to update our screen each iteration

surface = pygame.Surface((50, 50))  # Surface class gives us a rectangle
surface.fill((50, 50, 50))  # fill() method fills the object with an RGB color

skyScraper = pygame.Surface((50, 200))
skyScraper.fill((100, 100, 100))

surface2 = pygame.Surface((100, 100))
surface2.fill((100, 150, 255))

pos = [50, 50]  # Use an array to hold coordinate values

building = Building()

while True:
    events = pygame.event.get()  # Our array of pyGame events
    for event in events:   # Iterate through each event
        if event.type == pygame.QUIT:  # If we encounter an event of type QUIT, we quit pyGame and system exit
            pygame.quit()
            sys.exit()
        if event.type == pygame.KEYDOWN:  # Key listener
            if event.key == pygame.K_RIGHT:  # Down key action
                pos[0] += 10
            if event.key == pygame.K_LEFT:  # Down key action
                pos[0] -= 10

    pygame.draw.rect(background, (0, 255, 0), building)
    pygame.draw.ellipse(surface, (255, 0, 0), (25, 25, 25, 25), 20)  # Shapes are drawn onto surfaces
    screen.blit(background, (0, 0))
    screen.blit(skyScraper, (200, 200))
    screen.blit(surface, pos)
    screen.blit(surface2, (25, 75))

    FPS.tick(60)
    pygame.display.update()  # Our infinite loop which constantly updates our game
